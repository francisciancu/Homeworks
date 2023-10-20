package Homework31.pages;

import KeyDriver.BaseTestKeybooks;
import Utils.JsExecutorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostFormatsPage extends BaseTestKeybooks {
    public WebDriver driver;

    public static final By GALLERY_FORMAT = By.cssSelector("h4.post_title>a[href='https://keybooks.ro/2016/02/01/gallery-format/']");
    public static final By STICKY_TOP = By.cssSelector("div.top_panel_middle");

    public PostFormatsPage(WebDriver driver) {
        this.driver = driver;
        JsExecutorUtils.initialize(driver);
    }

    public boolean checkVisibilityOfTitle() {
        return JsExecutorUtils.checkVisibilityOfElement(driver.findElement(GALLERY_FORMAT));
    }

    public void scrollTitleIntoView() {
        JsExecutorUtils.scrollElementIntoView(driver.findElement(GALLERY_FORMAT));
    }

    public void moveToAvoidSticky() {
        JsExecutorUtils.moveUpToAvoidStickyElementCovering(driver.findElement(STICKY_TOP));
    }
    public void clickOnGalleryFormat() {
        JsExecutorUtils.clickOnElement(driver.findElement(GALLERY_FORMAT));
    }

}
