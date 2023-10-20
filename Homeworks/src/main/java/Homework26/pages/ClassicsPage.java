package Homework26.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClassicsPage extends BaseTestKeybooks {
    public WebDriver driver;
    public By SEARCH_FIELD = By.cssSelector("aside input.search_field");
    public By SEARCH_BUTTON = By.cssSelector("aside button[type='submit']");
    public By POST_TITLE = By.cssSelector("article > h4.post_title a[href='https://keybooks.ro/2016/02/02/why-i-wont-stop-buying-books/']");

    public String SEARCHED_TEXT = "Why";


    public ClassicsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchText(String value) {
        driver.findElement(SEARCH_FIELD).sendKeys(value);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public boolean checkBookPresence(WebElement element) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void clickOnPost(WebElement element) {
        element.click();
    }
}
