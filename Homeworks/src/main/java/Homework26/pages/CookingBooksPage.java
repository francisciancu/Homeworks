package Homework26.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CookingBooksPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By ALL_BOOKS = By.cssSelector("ul.products > li");
    public By ON_SALE_PATCH = By.cssSelector("ul.products > li span.onsale");

    public CookingBooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getSizeOfList(List<WebElement> element) {
        return element.size();
    }
}
