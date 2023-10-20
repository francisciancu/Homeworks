package Homework35.tests;

import Homework35.pages.HomePage;
import KeyDriver.BaseTestKeyFood;
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
                .chooseCategoryAndProduct(FRUITS_AND_VEGETABLES)
                .addToWishlistAndGoBackToHomePage()
                .chooseCategoryAndProduct(BREAKFAST_AND_DAIRY)
                .addToWishlistAndGoBackToHomePage()
                .chooseCategoryAndProduct(BEVERAGES)
                .addToWishlistAndGoBackToHomePage()
                .chooseCategoryAndProduct(BISCUITS_SNACKS)
                .addToWishlistAndGoBackToHomePage()
                .goToWishlist()
                .checkProductsName()
                .checkAddToCartButton()
                .checkAllProducts()
                .addAllToCart()
                .applyAction()
                .checkIfExpectedProductIsStillInTheList();

    }
}
