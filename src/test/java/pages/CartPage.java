package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addProductButton = By.cssSelector(".add-to-cart");
    private final By cartItems = By.cssSelector(".cart-item");
    private final By checkoutButton = By.id("checkout");
    private final By quantityField = By.cssSelector(".cart-item-quantity");
    private final By removeButton = By.cssSelector(".remove-item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** @return true if a button was found and clicked */
    public boolean addProductToCart(int index) {
        List<WebElement> buttons = driver.findElements(addProductButton);
        if (buttons.size() <= index) {
            return false;
        }
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(index))).click();
        return true;
    }

    public int cartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public boolean isProductInCart(int index) {
        return cartItemCount() > index;
    }

    public void removeProduct(int index) {
        List<WebElement> removes = driver.findElements(removeButton);
        if (removes.size() > index) {
            wait.until(ExpectedConditions.elementToBeClickable(removes.get(index))).click();
        }
    }

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void setProductQuantity(int index, int quantity) {
        List<WebElement> quantities = driver.findElements(quantityField);
        if (quantities.size() > index) {
            WebElement field = quantities.get(index);
            field.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(quantity), Keys.TAB);
        }
    }

    public int getProductQuantity(int index) {
        List<WebElement> quantities = driver.findElements(quantityField);
        if (quantities.size() > index) {
            return Integer.parseInt(quantities.get(index).getAttribute("value"));
        }
        return 0;
    }
}
