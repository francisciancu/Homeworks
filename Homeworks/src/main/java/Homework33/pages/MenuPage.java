package Homework33.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;
    private static final By SEARCH_BUTTON = By.cssSelector("div.menu_main_wrap button.search_submit");
    private static final By SEARCH_FIELD = By.cssSelector("div.menu_main_wrap input.search_field");
    private static final By SEARCHED_BOOK = By.cssSelector("div.search_results_content h6 a[href='https://keybooks.ro/shop/the-wicked-king/']");
    private static final String TEXT_TO_SEARCH = "king";

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForBook(){
        clickOnElement(SEARCH_BUTTON);
        sendKeys(SEARCH_FIELD,TEXT_TO_SEARCH);
    }
    public void openBookPage(){
        clickOnElement(SEARCHED_BOOK);
    }
}
