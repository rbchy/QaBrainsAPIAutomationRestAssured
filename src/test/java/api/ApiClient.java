package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

/**
 * One place that builds every API request: base URI from config.properties,
 * JSON in and out, and full request/response logging only when a check fails.
 */
public class ApiClient {

    private final RequestSpecification spec;
    private final String baseUrl;

    public ApiClient() {
        baseUrl = System.getProperty("base_url", BaseTest.config.getProperty("base_url"));
        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalStateException("base_url is missing from config.properties");
        }
        this.spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.URI)
                .build();
    }

    public String baseUri() {
        return baseUrl;
    }

    public Response get(String path) {
        return given().spec(spec).when().get(path).then().log().ifValidationFails().extract().response();
    }

    public Response post(String path, Object body) {
        return given().spec(spec).body(body).when().post(path).then().log().ifValidationFails().extract().response();
    }

    public Response put(String path, Object body) {
        return given().spec(spec).body(body).when().put(path).then().log().ifValidationFails().extract().response();
    }

    public Response delete(String path) {
        return given().spec(spec).when().delete(path).then().log().ifValidationFails().extract().response();
    }
}
