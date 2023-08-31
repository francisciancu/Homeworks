package Homework24.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By SHOP_LINK = By.xpath("//header[contains(@class,top_panel_wrap)]//a[text()='Books']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(WebElement element) {
        element.click();
    }

}
