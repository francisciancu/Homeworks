package Homework26.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BaseTestKeybooks {
    public WebDriver driver;
    public By COOKING_BOOKS = By.cssSelector("a[href='https://keybooks.ro/product-category/cookbooks/']");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCookingBooksCategory() {
        driver.findElement(COOKING_BOOKS).click();
    }
}
