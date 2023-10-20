package Homework25.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By POST_FORMATS_BUTTON = By.cssSelector("ul#menu_main a[href='https://keybooks.ro/category/post-formats/']");
    public By BLOG_BUTTON = By.linkText("BLOG");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPostFormats() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(BLOG_BUTTON)).perform();
        driver.findElement(POST_FORMATS_BUTTON).click();
    }
}
