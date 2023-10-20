package Homework35.pages;

import KeyDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static Utils.MyMethods.*;

public class WishlistPage extends BaseTestKeyFood {
    public WishlistPage() {
    }

    private static final By WISHLIST_PRODUCTS = By.cssSelector("td.product-name");
    private static final By CHECK_ALL = By.cssSelector("input.global-cb");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button[name='tinvwl-add-to-cart']");
    private static final By ACTIONS_LIST = By.cssSelector("select[name='product_actions']");
    private static final By APPLY_ACTION_BUTTON = By.cssSelector("span>button[name='tinvwl-action']");
    private static final By ERROR_MESSAGE = By.cssSelector("ul.woocommerce-error");
    private static final String ADD_ACTION = "add_selected";
    private static final String EXPECTED_ERROR_MESSAGE = "Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met.";
    private static final List<String> EXPECTED_PRODUCTS_LIST = Arrays.asList("Shimmer Pastel Almond Blend", "Zevia Kidz Strawberry Lemonade Zero Calorie Soda", "Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar", "Fresh Produce Melons Each");

    public WishlistPage checkProductsName() {
        var listOfProducts = getListOfTextFromElements(elements(WISHLIST_PRODUCTS));
        Assert.assertTrue(new HashSet<>(listOfProducts).containsAll(EXPECTED_PRODUCTS_LIST));
        return this;
    }

    public WishlistPage checkAddToCartButton() {
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
    public WishlistPage applyAction() {
        clickOnElement(APPLY_ACTION_BUTTON);
        return this;
    }
    public void checkIfExpectedProductIsStillInTheList(){
        Assert.assertEquals(getTextFromElement(ERROR_MESSAGE),EXPECTED_ERROR_MESSAGE);
        Assert.assertEquals(elements(WISHLIST_PRODUCTS).size(), 1);
        Assert.assertEquals(getTextFromElement(elements(WISHLIST_PRODUCTS).get(0)), "Zevia Kidz Strawberry Lemonade Zero Calorie Soda");

    }
}
