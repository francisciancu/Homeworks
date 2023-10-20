package Homework32.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.WebDriver;


public class BookPage extends BaseTestKeybooks {
    public WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBookLink() {
        return driver.getCurrentUrl();
    }

    public void goBackToMenuPage() {
        goBack();
    }
}
