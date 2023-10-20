package Homework35.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static Utils.MyMethods.*;

public class LoginPage {

    private static final By USERNAME_FIELD = By.cssSelector("input#username");
    private static final By PASSWORD_FIELD = By.cssSelector("input#password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[name='login']");
    private static final By LOGIN_CONFIRMATION_MESSAGE = By.cssSelector("div.woocommerce-MyAccount-content");
    private static final By HOME_BUTTON = By.cssSelector("ul#menu-menu-2  a[href='https://keyfood.ro/']");

    public LoginPage() {
    }

    public LoginPage inputUsername(String username) {
        sendKeys(USERNAME_FIELD, username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        sendKeys(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage clickOnLogin() {
        clickOnElement(LOGIN_BUTTON);
        return this;
    }

    public LoginPage checkLogin() {
        Assert.assertTrue(isVisible(LOGIN_CONFIRMATION_MESSAGE), "Failed Login");
        return this;
    }

    public HomePage goBackToHome() {
        clickOnElement(HOME_BUTTON);
        return new HomePage();
    }
}
