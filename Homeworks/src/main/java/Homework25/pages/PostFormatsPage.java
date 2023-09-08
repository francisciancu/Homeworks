package Homework25.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostFormatsPage extends BaseTestKeybooks {
    public WebDriver driver;

    public PostFormatsPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By AUDIO_POST_TITLE = By.cssSelector("h4.post_title > a[href='https://keybooks.ro/2016/02/02/audio-post/']");

    public void navigateToAudioPost() {
        driver.findElement(AUDIO_POST_TITLE).click();
    }

}
