package Homework28.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BaseTestKeybooks {
    public WebDriver driver;

    public By FACEBOOK_ICON = By.cssSelector("div.top_panel_top_socials span.icon-facebook");
    public By TWITTER_ICON = By.cssSelector("div.top_panel_top_socials span.icon-twitter");
    public By INSTAGRAM_ICON = By.cssSelector("div.top_panel_top_socials span.icon-instagramm");
    public By FACEBOOK_ANCHOR = By.cssSelector("div.top_panel_top_socials a.social_facebook");
    public By TWITTER_ANCHOR = By.cssSelector("div.top_panel_top_socials a.social_twitter");
    public By INSTAGRAM_ANCHOR = By.cssSelector("div.top_panel_top_socials a.social_instagramm");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHrefString(WebElement element){
        return element.getAttribute("href");
    }
}
