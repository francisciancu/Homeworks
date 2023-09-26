package Homework31.pages;

import Utils.JsExecutorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static Utils.RandomTextGenerator.generateRandomString;

public class GalleryFormatPage {
    public WebDriver driver;
    public By GALLERY_FORMAT_TITLE = By.cssSelector("h1.page_title");
    public By COMMENT_AREA = By.cssSelector("textarea#comment");
    public By AUTHOR_INPUT = By.cssSelector("input#author");
    public By EMAIL_INPUT = By.cssSelector("input#email");
    public By URL_INPUT = By.cssSelector("input#url");
    public By SEND_COMMENT_BUTTON = By.cssSelector("input#send_comment");
    public Map<String, String> VALUES_MAP = new HashMap<>();
    private final String COMMENT_TEXT = generateRandomString(20);
    private final String AUTHOR = generateRandomString(8);
    private final String EMAIL = generateRandomString(10) + "@email.com";
    private final String URL = generateRandomString(8);
    public By COMMENT_TEXT_ELEMENT = By.xpath(("//p[text()='" + COMMENT_TEXT + "']"));
    public By AUTHOR_TEXT_ELEMENT = By.xpath(("//span[text()='" + AUTHOR + "']"));


    public GalleryFormatPage(WebDriver driver) {
        this.driver = driver;
        JsExecutorUtils.initialize(driver);
    }

    public String getTitleText() {
        return JsExecutorUtils.getTextOfElement(driver.findElement(GALLERY_FORMAT_TITLE));
    }

    public void postComment() {
        VALUES_MAP.put("commentText", COMMENT_TEXT);
        VALUES_MAP.put("author", AUTHOR);
        VALUES_MAP.put("email", EMAIL);
        VALUES_MAP.put("url", URL);
        JsExecutorUtils.sendKeysToField(COMMENT_TEXT, driver.findElement(COMMENT_AREA));
        JsExecutorUtils.sendKeysToField(AUTHOR, driver.findElement(AUTHOR_INPUT));
        JsExecutorUtils.sendKeysToField(EMAIL, driver.findElement(EMAIL_INPUT));
        JsExecutorUtils.sendKeysToField(URL, driver.findElement(URL_INPUT));
        JsExecutorUtils.clickOnElement(driver.findElement(SEND_COMMENT_BUTTON));
    }

    public boolean checkVisibilityOfComment() {
        return JsExecutorUtils.checkVisibilityOfElement(driver.findElement(COMMENT_TEXT_ELEMENT));
    }

    public boolean checkVisibilityOfAuthor() {
        return JsExecutorUtils.checkVisibilityOfElement(driver.findElement(AUTHOR_TEXT_ELEMENT));
    }
    public String getCommentText(){
        return JsExecutorUtils.getTextOfElement(driver.findElement(COMMENT_TEXT_ELEMENT));
    }
    public String getAuthorText(){
        return JsExecutorUtils.getTextOfElement(driver.findElement(AUTHOR_TEXT_ELEMENT));
    }
}
