package stepdefinitions;

import api.ApiClient;
import api.TestData;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

/**
 * REST API steps (Rest Assured) against the base_url in config.properties.
 * Each "When" remembers which operation ran, so the shared
 * "Then API response should be valid" step applies the right checks.
 */
public class ApiSteps {

    private enum Operation { GET, CREATE, UPDATE, DELETE }

    private ApiClient api;
    private Response response;
    private Operation operation;
    private Map<String, Object> sentBody;
    private Scenario scenario;

    @Before("@api")
    public void rememberScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("API base URI is set")
    public void api_base_uri_is_set() {
        api = new ApiClient();
        Assert.assertNotNull(api.baseUri(), "base_url must be set in config.properties");
    }

    @When("I get user details")
    public void i_get_user_details() {
        operation = Operation.GET;
        response = api.get("/users/" + TestData.intValue("existingUserId"));
    }

    @When("I create a user")
    public void i_create_a_user() {
        operation = Operation.CREATE;
        sentBody = TestData.payload("createUser");
        response = api.post("/users", sentBody);
    }

    @When("I update user")
    public void i_update_user() {
        operation = Operation.UPDATE;
        sentBody = TestData.payload("updateUser");
        response = api.put("/users/" + TestData.intValue("existingUserId"), sentBody);
    }

    @When("I delete a user")
    public void i_delete_a_user() {
        operation = Operation.DELETE;
        response = api.delete("/users/" + TestData.intValue("existingUserId"));
    }

    @When("I call invalid endpoint")
    public void i_call_invalid_endpoint() {
        response = api.get(TestData.text("invalidEndpoint"));
    }

    @Then("API response should be valid")
    public void api_response_should_be_valid() {
        attachResponse();
        checkResponseTime();

        switch (operation) {
            case GET:
                assertStatus(200);
                assertJson();
                response.then().assertThat()
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/user-schema.json"));
                Assert.assertEquals(response.jsonPath().getInt("id"), TestData.intValue("existingUserId"),
                        "Returned user id");
                break;

            case CREATE:
                assertStatus(201);
                assertJson();
                Assert.assertNotNull(response.jsonPath().get("id"), "Created user must get an id");
                assertEchoed("name", "username", "email");
                break;

            case UPDATE:
                assertStatus(200);
                assertJson();
                Assert.assertEquals(response.jsonPath().getInt("id"), TestData.intValue("existingUserId"),
                        "Updated user id");
                assertEchoed("name", "username", "email");
                break;

            case DELETE:
                assertStatus(200);
                Assert.assertTrue(response.jsonPath().getMap("$").isEmpty(),
                        "DELETE should return an empty JSON object but returned: " + response.asString());
                break;

            default:
                Assert.fail("No API operation ran before this check");
        }
    }

    @Then("API should return error")
    public void api_should_return_error() {
        attachResponse();
        checkResponseTime();
        assertStatus(404);
    }

    // ---------- helpers ----------

    private void assertStatus(int expected) {
        Assert.assertEquals(response.statusCode(), expected,
                "HTTP status for " + operation + ". Body: " + response.asString());
    }

    private void assertJson() {
        String contentType = response.contentType();
        Assert.assertTrue(contentType != null && contentType.contains("application/json"),
                "Content-Type should be JSON but was: " + contentType);
    }

    private void checkResponseTime() {
        long max = TestData.intValue("maxResponseTimeMs");
        Assert.assertTrue(response.time() < max,
                "Response took " + response.time() + " ms (limit " + max + " ms)");
    }

    private void assertEchoed(String... fields) {
        for (String field : fields) {
            Assert.assertEquals(response.jsonPath().getString(field), String.valueOf(sentBody.get(field)),
                    "Field '" + field + "' in the response");
        }
    }

    private void attachResponse() {
        if (scenario != null && response != null) {
            scenario.attach(response.asPrettyString(), "application/json",
                    "Response " + response.statusCode() + " in " + response.time() + " ms");
        }
    }
}
