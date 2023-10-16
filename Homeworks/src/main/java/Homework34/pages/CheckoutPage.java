package Homework34.pages;

import KeyBooksDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Utils.MyMethods.*;

public class CheckoutPage extends BaseTestKeyFood {

    public CheckoutPage() {
    }

    private static final String EXPECTED_URL_CHECKOUT = "https://keyfood.ro/checkout-2/";
    private static final String EXPECTED_URL_ORDER_RECEIVED = "https://keyfood.ro/checkout-2/order-received/";
    private static final String EXPECTED_ORDER_RECEIVED_MESSAGE = "Thank you. Your order has been received.";
    private static final By PLACE_ORDER_BUTTON = By.cssSelector("button#place_order");
    private static final By TERMS_CHECKBOX = By.cssSelector("input.input-checkbox");
    private static final By ORDER_RECEIVED_MESSAGE = By.cssSelector("p.woocommerce-notice");
    private static final By ORDER_NUMBER = By.cssSelector("li.order>strong");

    public CheckoutPage checkIfOnCheckoutPage() {
        Assert.assertEquals(getCurrentUrl(), EXPECTED_URL_CHECKOUT);
        return this;
    }

    public CheckoutPage placeOrder() {
        waitForElementStaleness(TERMS_CHECKBOX);
        waitForElementNotStaleness(TERMS_CHECKBOX);
        clickOnElement(TERMS_CHECKBOX);
        clickOnElement(PLACE_ORDER_BUTTON);
        return this;
    }

    public void checkIfOrderReceived() {
        waitForUrlToNotBe(EXPECTED_URL_CHECKOUT);
        Assert.assertTrue(getCurrentUrl().contains(EXPECTED_URL_ORDER_RECEIVED));
        Assert.assertEquals(getTextFromElement(ORDER_RECEIVED_MESSAGE), EXPECTED_ORDER_RECEIVED_MESSAGE);
        var orderNumber = getTextFromElement(ORDER_NUMBER);
        Assert.assertFalse(orderNumber.isEmpty());
        Assert.assertTrue(Integer.parseInt(orderNumber) >= 0);
    }

}
