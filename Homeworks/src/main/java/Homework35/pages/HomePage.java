package Homework35.pages;

import KeyDriver.BaseTestKeyFood;
import Utils.EnumCategories;
import org.openqa.selenium.By;

import static Utils.MyMethods.clickOnElement;

public class HomePage extends BaseTestKeyFood {
    private static final By ACCOUNT_BUTTON = By.linkText("My account");
    private static final By FRUITS_AND_VEGETABLES_CATEGORY = By.cssSelector("div#all-categories a[href='https://keyfood.ro/product-category/fruits-vegetables/']");
    private static final By BREAKFAST_AND_DAIRY_CATEGORY = By.cssSelector("div#all-categories a[href='https://keyfood.ro/product-category/breakfast-dairy/']");
    private static final By BEVERAGES_CATEGORY = By.cssSelector("div#all-categories a[href='https://keyfood.ro/product-category/beverages/']");
    private static final By BISCUITS_SNACKS_CATEGORY = By.cssSelector("div#all-categories a[href='https://keyfood.ro/product-category/biscuits-snacks/']");
    private static final By MY_WISHLIST_BUTTON = By.cssSelector("a[href='https://keyfood.ro/wishlist/']");

    public HomePage() {
    }

    public LoginPage clickOnAccountToLogin() {
        clickOnElement(ACCOUNT_BUTTON);
        return new LoginPage();
    }

    public ProductsPage clickOnCategory(EnumCategories category) {
        switch (category) {
            case FRUITS_AND_VEGETABLES->{
                clickOnElement(FRUITS_AND_VEGETABLES_CATEGORY);
            }
            case BREAKFAST_AND_DAIRY->{
                clickOnElement(BREAKFAST_AND_DAIRY_CATEGORY);
            }
            case BEVERAGES->{
                clickOnElement(BEVERAGES_CATEGORY);
            }
            case BISCUITS_SNACKS->{
                clickOnElement(BISCUITS_SNACKS_CATEGORY);
            }
        }
        return new ProductsPage(category);

    }
    public WishlistPage goToWishlist(){
        clickOnElement(MY_WISHLIST_BUTTON);
        return new WishlistPage();
    }
}
