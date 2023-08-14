package Homework18;

import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTestKeybooks {

    public static final By loginButton = By.cssSelector("a[href='#popup_login']");
    public static final By usernameField = By.cssSelector("input[placeholder='Login or Email']");
    public static final By passwordField = By.cssSelector("input[placeholder='Password']");

    @Test(description = "Check if fields appears when clicking the login button")
    public static void loginButton() throws InterruptedException {

        var loginButtonsList = driver.findElements(loginButton);
        var usernameList = driver.findElements(usernameField);
        var passwordList = driver.findElements(passwordField);

        assertFalse(usernameList.get(0).isDisplayed(),
                "Campul username este vizibil pana sa dam click pe butonul de login");

        assertFalse(passwordList.get(0).isDisplayed(),
                "Campul password este vizibil pana sa dam click pe butonul de login");

        assertTrue(loginButtonsList.get(0).isDisplayed(),
                "Login Button not found");

        loginButtonsList.get(0).click();
        Thread.sleep(1000);

        assertTrue(usernameList.get(0).isDisplayed(),
                "Campul username nu este vizibil dupa ce dam click pe butonul de login");

        assertTrue(passwordList.get(0).isDisplayed(),
                "Campul nu password este vizibil dupa ce dam click pe butonul de login");

        System.out.println("Everything works as expected");

    }
}
