package Homework34.pages;

import KeyDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Utils.MyMethods.*;

public class CartPage extends BaseTestKeyFood {
    public CartPage() {
    }

    private static final String EXPECTED_URL = "https://keyfood.ro/cart-2/";
    private static final By PLUS_BUTTON = By.cssSelector("i.klbth-icon-plus");
    private static final By PRICE = By.cssSelector("td[data-title='Total'] bdi");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("div.wc-proceed-to-checkout");

    public CartPage checkIfOnCartPage() {
        Assert.assertEquals(getCurrentUrl(), EXPECTED_URL);
        return this;
    }

    public CartPage checkIfPriceUpdates() {
        var startingPrice = Float.parseFloat(getTextFromElement(PRICE).replace("$", ""));
        clickOnElement(PLUS_BUTTON);
        waitForElementToUpdate(PRICE, "$" + startingPrice);
        var updatedPrice = Float.parseFloat(getTextFromElement(PRICE).replace("$", ""));
        Assert.assertTrue((updatedPrice > startingPrice));
        return this;
    }

    public CheckoutPage proceedToCheckout() {
        clickOnElement(PROCEED_TO_CHECKOUT_BUTTON);
        return new CheckoutPage();
    }
}
