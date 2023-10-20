package Homework23.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By LOGIN_LINK = By.linkText("Login");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(WebElement element) {
        element.click();
    }

}
