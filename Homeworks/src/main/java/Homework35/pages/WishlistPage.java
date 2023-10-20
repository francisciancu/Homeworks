package Homework35.pages;

import KeyBooksDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static Utils.MyMethods.*;

public class WishlistPage extends BaseTestKeyFood {
    public WishlistPage() {
    }

    private static final By WISHLIST_PRODUCTS = By.className("td.product-name");
    private static final By CHECK_ALL = By.className("input.global-cb");
    private static final By ADD_TO_CART_BUTTON = By.className("button[name='tinvwl-add-to-cart']");
    private static final By ACTIONS_LIST = By.className("select[name='product_actions']");
    private static final String ADD_ACTION = "add_selected";

    //
    private static final List<String> EXPECTED_PRODUCTS_LIST = Arrays.asList("Shimmer Pastel Almond Blend", "Zevia Kidz Strawberry Lemonade Zero Calorie Soda", "Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar", "Fresh Produce Melons Each");

    public WishlistPage checkProductsName() {
        var listOfProducts = elements(WISHLIST_PRODUCTS);
        for (var product : listOfProducts) {
            Assert.assertTrue(EXPECTED_PRODUCTS_LIST.contains(product.getText()), "Unexpected product found in wishlist");
        }
        return this;
    }

    public WishlistPage checkAddToCartButton() {

        ///TODO: POSIBIL SA MEARGA DA S  ADAT UPDATE LA CHROME LA 118 (am driver de 116)
        var test = elements(ADD_TO_CART_BUTTON);
        for (var test2 : test) {
            System.out.println(test2.getText());
        }
        System.out.println(elements(ADD_TO_CART_BUTTON).size());

        Assert.assertEquals(elements(ADD_TO_CART_BUTTON).size(), EXPECTED_PRODUCTS_LIST.size());
        return this;
    }

    public WishlistPage checkAllProducts() {
        clickOnElement(CHECK_ALL);
        return this;
    }

    public WishlistPage addAllToCart() {
        new Select(element(ACTIONS_LIST)).selectByValue(ADD_ACTION);
        return this;
    }

    public void waiHere() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
