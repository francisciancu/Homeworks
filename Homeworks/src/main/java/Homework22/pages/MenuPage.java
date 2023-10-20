package Homework22.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By SINGLE_AUTHOR = By.linkText("SINGLE AUTHOR");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(By locator) {
        driver.findElement(locator).click();
    }

}
