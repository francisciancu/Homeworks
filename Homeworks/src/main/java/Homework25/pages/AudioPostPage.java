package Homework25.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AudioPostPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By SONG_SLIDER = By.cssSelector("span[role='slider']");
    public By PLAY_PAUSE_BUTTON = By.cssSelector("div.mejs-playpause-button");
    public By VOLUME_SLIDER = By.cssSelector("div.mejs-horizontal-volume-current");

    public AudioPostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void activateSliderWithClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void moveSongSlider(WebElement element) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 200, 0).perform();
    }

    public void moveVolumeSlider(WebElement element) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 50, 0).perform();
    }
}
