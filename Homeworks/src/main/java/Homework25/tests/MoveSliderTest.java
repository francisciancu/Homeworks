package Homework25.tests;

import Homework25.pages.AudioPostPage;
import Homework25.pages.MenuPage;
import Homework25.pages.PostFormatsPage;
import KeyBooksDriver.BaseTestKeybooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoveSliderTest extends BaseTestKeybooks {

    @Test
    public void MoveSliderTest() {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToPostFormats();

        PostFormatsPage postFormatsPage = new PostFormatsPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/category/post-formats/");
        postFormatsPage.navigateToAudioPost();
        Assert.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/2016/02/02/audio-post/");

        AudioPostPage audioPostPage = new AudioPostPage(driver);
        audioPostPage.activateSliderWithClick(driver.findElement(audioPostPage.PLAY_PAUSE_BUTTON));
        audioPostPage.moveSongSlider(driver.findElement(audioPostPage.SONG_SLIDER));
        audioPostPage.moveVolumeSlider(driver.findElement(audioPostPage.VOLUME_SLIDER));

        System.out.println("Everything works as expected");
    }
}
