package Homework26.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By CLASSICS_BUTTON = By.cssSelector("ul#menu_main a[href='https://keybooks.ro/category/classic/']");
    public By BLOG_BUTTON = By.linkText("BLOG");
    public By BOOKS_BUTTON = By.cssSelector("div.top_panel_middle a[href='https://keybooks.ro/shop/']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToClassics() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(BLOG_BUTTON)).perform();
        driver.findElement(CLASSICS_BUTTON).click();
    }

    public void navigateToBooks() {
        driver.findElement(BOOKS_BUTTON).click();
    }
}
