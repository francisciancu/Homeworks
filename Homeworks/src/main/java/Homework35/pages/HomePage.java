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
    private static final By MELON_PRODUCT = By.cssSelector("main div.thumbnail-wrapper >a[href='https://keyfood.ro/product/fresh-produce-melons-each/']");
    private static final By EGG_BITES_PRODUCT = By.cssSelector("main div.thumbnail-wrapper >a[href='https://keyfood.ro/product/vital-farms-pasture-raised-egg-bites-bacon-cheddar/']");
    private static final By SHIMMER_PASTEL_PRODUCT = By.cssSelector("main div.thumbnail-wrapper >[href='https://keyfood.ro/product/shimmer-pastel-almond-blend/']");
    private static final By ZEVIA_PRODUCT = By.cssSelector("main div.thumbnail-wrapper >a[href='https://keyfood.ro/product/zevia-kidz-strawberry-lemonade-zero-calorie-soda/']");

    public HomePage() {
    }

    public LoginPage clickOnAccountToLogin() {
        clickOnElement(ACCOUNT_BUTTON);
        return new LoginPage();
    }

    public ProductPage chooseCategoryAndProduct(EnumCategories category) {
        switch (category) {
            case FRUITS_AND_VEGETABLES->{
                clickOnElement(FRUITS_AND_VEGETABLES_CATEGORY);
                clickOnElement(MELON_PRODUCT);
            }
            case BREAKFAST_AND_DAIRY->{
                clickOnElement(BREAKFAST_AND_DAIRY_CATEGORY);
                clickOnElement(EGG_BITES_PRODUCT);
            }
            case BEVERAGES->{
                clickOnElement(BEVERAGES_CATEGORY);
                clickOnElement(ZEVIA_PRODUCT);
            }
            case BISCUITS_SNACKS->{
                clickOnElement(BISCUITS_SNACKS_CATEGORY);
                clickOnElement(SHIMMER_PASTEL_PRODUCT);
            }
        }
        return new ProductPage();

    }
    public WishlistPage goToWishlist(){
        clickOnElement(MY_WISHLIST_BUTTON);
        return new WishlistPage();
    }
}
