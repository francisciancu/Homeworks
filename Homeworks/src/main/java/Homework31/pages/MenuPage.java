package Homework31.pages;

import KeyDriver.BaseTestKeybooks;
import Utils.JsExecutorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By POST_FORMATS_BUTTON = By.cssSelector("ul#menu_main a[href='https://keybooks.ro/category/post-formats/']");
    public By BLOG_BUTTON = By.linkText("BLOG");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        JsExecutorUtils.initialize(driver);
    }

    public void navigateToPostFormats() {
        JsExecutorUtils.hoverOverElement(driver.findElement(BLOG_BUTTON));
        JsExecutorUtils.clickOnElement(driver.findElement(POST_FORMATS_BUTTON));
    }
}
