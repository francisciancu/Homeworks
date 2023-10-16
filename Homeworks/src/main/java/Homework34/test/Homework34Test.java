package Homework34.test;

import Homework34.pages.MainPage;
import KeyBooksDriver.BaseTestKeyFood;
import Utils.DataProviderClass;
import org.testng.annotations.Test;

public class Homework34Test extends BaseTestKeyFood {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "keyFoodAccount")
    public void MenuBooksTest(String user, String pass) {
        new MainPage()
                .clickOnAccountToLogin()
                .inputUsername(user)
                .inputPassword(pass)
                .clickOnLogin()
                .checkLogin()
                .goBackToHome()
                .clickOnCategory()
                .checkIfOnProductsCategoriesPage()
                .clickOnProduct()
                .checkIfOnProductPage()
                .clickAddToCart()
                .checkForConfirmationAlert()
                .clickOnViewCartButton()
                .checkIfOnCartPage()
                .checkIfPriceUpdates()
                .proceedToCheckout()
                .checkIfOnCheckoutPage()
                .placeOrder()
                .checkIfOrderReceived();

    }
}
