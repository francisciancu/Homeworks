package Homework23.pages;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BaseTestKeybooks {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public By USERNAME_FIELD = By.id("log");
    public By PASSWORD_FIELD = By.id("password");
    public By SUBMIT_BUTTON = By.cssSelector("li input[value='Login']");

    public By SUCESS_LOGIN_POPUP = By.cssSelector("div[class*='sc_infobox_style_success']");
    public By LOGOUT_BUTTON = By.linkText("Logout");

    public By SETTINGS = By.linkText("Settings");
    public By ACCOUNT_NAME = By.cssSelector("a[href='#']");


    public void loginInApp(String user, String pass) {
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public boolean checkLoginMessageIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void logoutFromApp() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
    public void navigateToSettings(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(ACCOUNT_NAME)).perform();
        driver.findElement(SETTINGS).click();
    }
}
