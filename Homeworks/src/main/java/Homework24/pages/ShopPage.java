package Homework24.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ShopPage extends BaseTestKeybooks {
    public By LIST_OF_BOOKS = By.xpath("//ul[@class='products columns-4']/li//a[contains(@class,'hover_icon_link')]");
    public By CHOSEN_BOOK = By.xpath("//a[contains(@class,'hover_icon_link')][@href='https://keybooks.ro/shop/a-hundred-and-one-receipes/']");

    public WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(WebElement element) {
        element.click();
    }
    private List<WebElement> getListOfBooks(){
        return driver.findElements(LIST_OF_BOOKS);
    }
    private WebElement chooseRandomBook(){
        return getListOfBooks().get(new Random().nextInt(getListOfBooks().size()));
    }
    public void clickOnRandomBook(){
        chooseRandomBook().click();
    }

    public void clickOnChosenBook(){
        driver.findElement(CHOSEN_BOOK).click();
    }
}
