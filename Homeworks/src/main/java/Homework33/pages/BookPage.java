package Homework33.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookPage extends BaseTestKeybooks {
    public WebDriver driver;
    public final String EXPECTED_BOOK_URL = "https://keybooks.ro/shop/the-wicked-king/";
    public final By BOOK_CATEGORY = By.cssSelector("span.posted_in a[rel='tag']");
    public final By BOOK_PRODUCT_ID = By.cssSelector("span.product_id span");
    public final By BOOK_PHOTOS = By.cssSelector("ol.flex-control-nav>li>img");
    public final String EXPECTED_BOOK_CATEGORY = "New releases";
    public final String EXPECTED_BOOK_PRODUCT_ID = "1709";
    private static final List<String> EXPECTED_BOOK_IMGS = Arrays.asList("TheWickedKing1", "TheWickedKing2", "TheWickedKing3", "TheWickedKing4");

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBookCategory() {
        return getTextFromElement(BOOK_CATEGORY);
    }

    public String getBookProductId() {
        return getTextFromElement(BOOK_PRODUCT_ID);
    }

    private boolean checkBookImgSrc(WebElement element, String expectedImg) {
        return element.getAttribute("src").contains(expectedImg + "-100x100.png");
    }

    private List<WebElement> getListOfImg() {
        return elements(BOOK_PHOTOS);
    }

    public boolean checkAllBookImg() {
        var bookImgs = getListOfImg();
        var finalAnswer = true;
        for (WebElement bookImg : bookImgs) {
            var validation = false;
            for (String expectedBookImg : EXPECTED_BOOK_IMGS) {
                validation = checkBookImgSrc(bookImg, expectedBookImg);
                if (validation) {
                    break;
                }
            }
            finalAnswer = validation;
            if (!finalAnswer){
                break;
            }
        }
        return finalAnswer;
    }

}
