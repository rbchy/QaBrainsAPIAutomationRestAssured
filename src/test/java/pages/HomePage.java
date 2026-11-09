package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Home page unique element =====
    @FindBy(css = "header")
    private WebElement homeHeader;

    // ===== Navigation links (STABLE XPath) =====
    @FindBy(xpath = "//a[contains(@href,'catalog')]")
    private WebElement catalogLink;

    @FindBy(xpath = "//a[contains(@href,'about')]")
    private WebElement aboutLink;

    @FindBy(xpath = "//a[contains(@href,'blog')]")
    private WebElement blogLink;

    @FindBy(xpath = "//a[contains(@href,'wishlist')]")
    private WebElement wishListLink;

    @FindBy(xpath = "//a[contains(@href,'refer')]")
    private WebElement referFriendLink;

    // ===== Search elements =====
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'No results') or contains(text(),'no products')]")
    private WebElement noResultMessage;

    // ===== Getters =====
    public WebElement getHomeHeader() {
        return homeHeader;
    }

    public WebElement getCatalogLink() {
        return catalogLink;
    }

    public WebElement getAboutLink() {
        return aboutLink;
    }

    public WebElement getBlogLink() {
        return blogLink;
    }

    public WebElement getWishListLink() {
        return wishListLink;
    }

    public WebElement getReferFriendLink() {
        return referFriendLink;
    }

    // ===== Search actions =====
    public void enterSearchText(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isNoResultDisplayed() {
        return noResultMessage.isDisplayed();
    }
}
