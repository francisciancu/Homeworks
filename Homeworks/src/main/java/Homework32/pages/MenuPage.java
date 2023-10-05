package Homework32.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;
    public final String MENU_PAGE_URL = "https://keybooks.ro/";


    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnBook(WebElement element) {
        clickOnElement(element);
    }

    public String getMenuPageUrl() {
        return driver.getCurrentUrl();
    }


}
