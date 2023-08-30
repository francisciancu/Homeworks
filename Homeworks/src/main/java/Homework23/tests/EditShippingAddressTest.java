package Homework23.tests;

import Homework23.pages.AccountPage;
import Homework23.pages.LoginPage;
import Homework23.pages.MenuPage;
import Homework23.pages.ShippingAddressPage;
import KeyBooksDriver.BaseTestKeybooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EditShippingAddressTest extends BaseTestKeybooks {

    @Test(priority = 1)
    public void setShippingAddress() {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(driver.findElement(menuPage.LOGIN_LINK));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInApp("TestUser", "12345@67890");
        assertTrue(loginPage.checkLoginMessageIsDisplayed(driver.findElement(loginPage.SUCESS_LOGIN_POPUP)));
        assertTrue(driver.findElement(loginPage.LOGOUT_BUTTON).isDisplayed());
        loginPage.navigateToSettings();
        assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/");
        AccountPage accountPage = new AccountPage(driver);
        accountPage.navigateToShippingAddress();
        assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/edit-address/shipping/");
        ShippingAddressPage shippingAddressPage = new ShippingAddressPage(driver);
        shippingAddressPage.countryRegionSelect(41);

        assertEquals(shippingAddressPage.getSelectedOption(driver.findElement(shippingAddressPage.COUNTRY_REGION)),
                "Canada");

        shippingAddressPage.provinceSelect("NL");

        assertEquals(shippingAddressPage.getSelectedOption(driver.findElement(shippingAddressPage.PROVINCE)),
                "Newfoundland and Labrador");

        System.out.println("Everything works as expected");
    }
}
