package Homework20;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTestKeybooks {
    private static final String ADD_TO_CART_CONF_TEXT = "“The story about me” has been added to your cart.";
    private static final String TITLE_OF_BOOK = "The story about me";
    private static final By SEARCH_BUTTON = By.cssSelector("button.search_submit");
    private static final By SEARCH_FIELD = By.cssSelector("input.search_field");
    private static final  By LOAD_MORE_BUTTON = By.cssSelector("a.viewmore_button");
    private static final  By BOOKS = By.cssSelector("h4.post_title");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button.single_add_to_cart_button");


    @Test
    private void findAndAddBookToCart() throws InterruptedException {
        var searchButtonList = driver.findElement(SEARCH_BUTTON);
        var searchField = driver.findElement(SEARCH_FIELD);
        Actions actions = new Actions(driver);

        searchButtonList.click();
        Thread.sleep(2000);
        assertTrue(searchField.isDisplayed(), "Search Field is not showing");
        searchField.sendKeys(TITLE_OF_BOOK);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        var loadMoreButton = driver.findElement(LOAD_MORE_BUTTON);

        while (loadMoreButton.isDisplayed()){
            loadMoreButton.click();
            Thread.sleep(2000);
        }

        var listOfBooks = driver.findElements(BOOKS);
        for (var book:listOfBooks) {
            System.out.println(book.getText());
            if (book.getText().equals(TITLE_OF_BOOK)){
                book.click();
                break;
            }
            Thread.sleep(2000);
            actions.scrollToElement(book);
            actions.perform();
            Thread.sleep(2000);
        }
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-story-about-me/","Actual URL doesn't match the expected one");
        Thread.sleep(2000);
        var addToCartButton = driver.findElement(ADD_TO_CART_BUTTON);
        addToCartButton.click();
        Thread.sleep(2000);



    }

    @Test
    public void checkIfCartWorks() {

    }
}
