package Homework35.tests;

import Homework35.pages.HomePage;
import KeyBooksDriver.BaseTestKeyFood;
import Utils.DataProviderClass;
import static Utils.EnumCategories.*;

import org.testng.annotations.Test;

public class Homework35Test extends BaseTestKeyFood {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "keyFoodAccount")
    public void homework35Test(String user, String pass) {

        new HomePage()
                .clickOnAccountToLogin()
                .inputUsername(user)
                .inputPassword(pass)
                .clickOnLogin()
                .checkLogin()
                .goBackToHome()
                .clickOnCategory(FRUITS_AND_VEGETABLES)
                .clickOnProduct()
                .addToWishlistAndGoBackToHomePage()
                .clickOnCategory(BREAKFAST_AND_DAIRY)
                .clickOnProduct()
                .addToWishlistAndGoBackToHomePage()
                .clickOnCategory(BEVERAGES)
                .clickOnProduct()
                .addToWishlistAndGoBackToHomePage()
                .clickOnCategory(BISCUITS_SNACKS)
                .clickOnProduct()
                .addToWishlistAndGoBackToHomePage()
                .goToWishlist()
                .checkProductsName()
                .checkAddToCartButton()
                .checkAllProducts()
                .addAllToCart().waiHere();

    }
}
