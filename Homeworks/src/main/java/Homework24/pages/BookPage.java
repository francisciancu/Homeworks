package Homework24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPage {
    public WebDriver driver;

    public By BOOK_SEARCH_ICON = By.xpath("//a[@class='woocommerce-product-gallery__trigger']");
    public By BOOK_TITLE = By.xpath("//h1[contains(@class,entry-title)]");
    public By BOOK_RATING = By.xpath("//div[@class='woocommerce-product-rating']//div[@class='star-rating']");
    public By BOOK_PRICE = By.xpath("//div[contains(@class,'entry-summary')]//ins//span[contains(@class,amount)]//bdi");
    public By BOOK_DESCRIPTION = By.xpath("//div[@class='woocommerce-product-details__short-description']");
    public By BOOK_QUANTITY = By.xpath("//input[@type='number']");
    public By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    public By BOOK_INFO = By.xpath("//div[@class='product_meta']");

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(WebElement element) {
        element.click();
    }

    public boolean checkIfElementIsDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }


}
