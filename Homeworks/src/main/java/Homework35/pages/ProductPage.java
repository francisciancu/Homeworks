package Homework35.pages;

import KeyDriver.BaseTestKeyFood;
import org.openqa.selenium.By;

import static Utils.MyMethods.clickOnElement;

public class ProductPage extends BaseTestKeyFood {
    private static final By HOME_BUTTON = By.cssSelector("ul#menu-menu-2  a[href='https://keyfood.ro/']");
    private static final By ADD_TO_WISHLIST_BUTTON = By.cssSelector("div.product-actions  a[aria-label='Add to Wishlist']");
    private static final By ADD_TO_WISHLIST_CLOSE_BUTTON = By.cssSelector("button.tinvwl_button_close");
    public ProductPage(){}
    public HomePage addToWishlistAndGoBackToHomePage(){
        clickOnElement(ADD_TO_WISHLIST_BUTTON);
        clickOnElement(ADD_TO_WISHLIST_CLOSE_BUTTON);
        clickOnElement(HOME_BUTTON);
        return new HomePage();
    }

}

