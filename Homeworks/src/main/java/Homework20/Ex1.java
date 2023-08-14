package Homework20;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTestKeybooks {
    private static final String ADD_TO_CART_CONF_TEXT = "“The story about me” has been added to your cart.";
    private static final String TITLE_OF_BOOK = "The story about me";
    private static final By SEARCH_BUTTON = By.cssSelector("button.search_submit");
    private static final By SEARCH_FIELD = By.cssSelector("input.search_field");
    private static final By LOAD_MORE_BUTTON = By.cssSelector("a.viewmore_button");
    private static final By BOOKS = By.cssSelector("h4.post_title");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button.single_add_to_cart_button");
    private static final By CONFIRMATION_MESSAGE = By.cssSelector("div.woocommerce-message");
    private static final By VIEW_CART_BUTTON = By.cssSelector("a[tabindex='1']");
    private static final By QUANTITY_FIELD = By.cssSelector("input[type='number']");
    private static final By UPDATE_CART_BUTTON = By.cssSelector("button[name='update_cart']");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("a.checkout-button");
    private static final By BILLING_DETAILS = By.cssSelector("div.woocommerce-billing-fields>h3");
    private static final By ADDITIONAL_INFORMATION = By.cssSelector("div.woocommerce-additional-fields>h3");


    @Test(priority = 1)
    private void findAndAddBookToCart() throws InterruptedException {
        var searchButtonList = driver.findElement(SEARCH_BUTTON);
        var searchField = driver.findElement(SEARCH_FIELD);

        searchButtonList.click();
        Thread.sleep(2000);
        assertTrue(searchField.isDisplayed(), "Search Field is not showing");
        searchField.sendKeys(TITLE_OF_BOOK);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        var loadMoreButton = driver.findElement(LOAD_MORE_BUTTON);

        while (loadMoreButton.isDisplayed()) {
            loadMoreButton.click();
            Thread.sleep(2000);
        }

        var listOfBooks = driver.findElements(BOOKS);
        for (var book : listOfBooks) {
            if (book.getText().equals(TITLE_OF_BOOK)) {
                book.click();
                break;
            }
            Thread.sleep(2000);
        }
        assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/", "Actual URL doesn't match the expected one");
        Thread.sleep(2000);

        var addToCartButton = driver.findElement(ADD_TO_CART_BUTTON);

        addToCartButton.click();
        Thread.sleep(2000);

        var cartAddMessage = driver.findElement(CONFIRMATION_MESSAGE);
        assertTrue(cartAddMessage.getText().contains(ADD_TO_CART_CONF_TEXT),"The confirmation message does not match");

        var viewCartButton = driver.findElement(VIEW_CART_BUTTON);
        Assert.assertTrue(viewCartButton.isDisplayed(),"The 'View Cart' button is not displayed");
        viewCartButton.click();
        Thread.sleep(2000);
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/cart/","Actual URL doesn't match the expected one");

    }

    @Test(priority = 2, dependsOnMethods = "findAndAddBookToCart")
    public void checkIfCartWorks() throws InterruptedException {
        var quantityField = driver.findElement(QUANTITY_FIELD);
        var updateCartButton = driver.findElement(UPDATE_CART_BUTTON);

        quantityField.clear();
        quantityField.sendKeys("2");
        Thread.sleep(1000);
        updateCartButton.click();
        Thread.sleep(2000);

        var cartUpdatedMEssage = driver.findElement(CONFIRMATION_MESSAGE);
        assertEquals(cartUpdatedMEssage.getText(),"Cart updated.","No message for cart updated");

        var proceedToCheckoutButton = driver.findElement(PROCEED_TO_CHECKOUT_BUTTON);
        proceedToCheckoutButton.click();
        Thread.sleep(2000);
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/checkout/","Actual URL doesn't match the expected one");

        var billingDetails = driver.findElement(BILLING_DETAILS);
        assertEquals(billingDetails.getText(),"Billing details","Billing details text does not match");

        var additionalInformation = driver.findElement(ADDITIONAL_INFORMATION);
        assertEquals(additionalInformation.getText(),"Additional information","Additional information text does not match");

        System.out.println("Everything works as expected");

    }
}
