package Homework34.pages;

import KeyBooksDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Utils.MyMethods.*;

public class ProductPage extends BaseTestKeyFood {
    private static final String EXPECTED_URL = "https://keyfood.ro/product";
    private static final String CONFIRMATION_MESSAGE = "has been added to your cart.";
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button[name='add-to-cart']");
    private static final By CONFIRMATION_ALERT = By.cssSelector("div[role='alert']");
    private static final By VIEW_CART_BUTTON = By.cssSelector("div[role='alert']>a");

    public ProductPage() {
    }

    public ProductPage checkIfOnProductPage() {
        Assert.assertTrue(getCurrentUrl().contains(EXPECTED_URL));
        return this;
    }

    public ProductPage clickAddToCart() {
        clickOnElement(ADD_TO_CART_BUTTON);
        return this;
    }

    public ProductPage checkForConfirmationAlert() {
        Assert.assertTrue(isVisible(CONFIRMATION_ALERT));
        Assert.assertTrue(getTextFromElement(CONFIRMATION_ALERT).contains(CONFIRMATION_MESSAGE));
        return this;
    }

    public CartPage clickOnViewCartButton() {
        clickOnElement(VIEW_CART_BUTTON);
        return new CartPage();
    }
}
