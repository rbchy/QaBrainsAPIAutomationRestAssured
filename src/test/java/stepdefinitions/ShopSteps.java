package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.List;

/** Cart, smoke navigation and regression shop steps. */
public class ShopSteps {

    private final List<String> visitedUrls = new ArrayList<>();
    private int requestedQuantity;

    private WebDriver driver() {
        return BaseTest.getDriver();
    }

    private CartPage cart() {
        return new CartPage(driver());
    }

    private HomePage home() {
        return new HomePage(driver());
    }

    // ---------- cart ----------

    @When("User adds products to cart")
    public void user_adds_products_to_cart() {
        Assert.assertTrue(cart().addProductToCart(0), "No 'add to cart' button found on the page");
    }

    @Then("Product should appear in cart")
    public void product_should_appear_in_cart() {
        Assert.assertTrue(cart().isProductInCart(0), "Product was not found in the cart after adding");
    }

    @Then("Products should be added successfully")
    public void products_should_be_added_successfully() {
        Assert.assertTrue(cart().cartItemCount() > 0, "Cart is empty after adding products");
    }

    @When("User removes product from cart")
    public void user_removes_product_from_cart() {
        cart().removeProduct(0);
    }

    @Then("Cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertFalse(cart().isProductInCart(0), "Product is still in the cart after removing");
    }

    @When("User updates product quantity")
    public void user_updates_product_quantity() {
        Assert.assertTrue(cart().addProductToCart(0), "No 'add to cart' button found on the page");
        requestedQuantity = 2;
        cart().setProductQuantity(0, requestedQuantity);
    }

    @Then("Quantity should be updated")
    public void quantity_should_be_updated() {
        Assert.assertEquals(cart().getProductQuantity(0), requestedQuantity, "Cart quantity");
    }

    // ---------- search ----------

    @When("User searches for invalid item")
    public void user_searches_for_invalid_item() {
        home().enterSearchText("zzqx-no-such-product-123");
        home().clickSearchButton();
    }

    @Then("No result should be displayed")
    public void no_result_should_be_displayed() {
        Assert.assertTrue(home().isNoResultDisplayed(), "Expected a 'no results' message");
    }

    // ---------- smoke navigation ----------

    @When("User clicks on Catalog, About and Blog")
    public void user_clicks_on_catalog_about_and_blog() {
        visit(home().getCatalogLink(), "Catalog");
        visit(home().getAboutLink(), "About");
        visit(home().getBlogLink(), "Blog");
    }

    @When("User clicks on Wish list and Refer a Friend")
    public void user_clicks_on_wish_list_and_refer_a_friend() {
        visit(home().getWishListLink(), "Wish list");
        visit(home().getReferFriendLink(), "Refer a Friend");
    }

    @Then("Pages should navigate correctly")
    public void pages_should_navigate_correctly() {
        assertVisited(3);
    }

    @Then("Pages should open successfully")
    public void pages_should_open_successfully() {
        assertVisited(2);
    }

    private void visit(WebElement link, String name) {
        String before = driver().getCurrentUrl();
        link.click();
        String after = driver().getCurrentUrl();
        Assert.assertNotEquals(after, before, "Clicking '" + name + "' did not change the page");
        visitedUrls.add(after);
        driver().navigate().back();
    }

    private void assertVisited(int expected) {
        Assert.assertEquals(visitedUrls.size(), expected, "Pages visited: " + visitedUrls);
        Assert.assertEquals(visitedUrls.stream().distinct().count(), (long) expected,
                "Each link should open its own page: " + visitedUrls);
    }
}
