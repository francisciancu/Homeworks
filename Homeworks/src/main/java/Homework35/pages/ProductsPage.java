package Homework35.pages;

import KeyBooksDriver.BaseTestKeyFood;
import Utils.EnumCategories;
import org.openqa.selenium.By;

import static Utils.MyMethods.clickOnElement;

public class ProductsPage extends BaseTestKeyFood {
    private static EnumCategories SELECTED_CATEGORY;
    private static final By MELON_PRODUCT = By.cssSelector("div >a[href='https://keyfood.ro/product/fresh-produce-melons-each/']");
    private static final By EGG_BITES_PRODUCT = By.cssSelector("div >a[href='https://keyfood.ro/product/vital-farms-pasture-raised-egg-bites-bacon-cheddar/']");
    private static final By SHIMMER_PASTEL_PRODUCT = By.cssSelector("div >a[href='https://keyfood.ro/product/shimmer-pastel-almond-blend/']");
    private static final By ZEVIA_PRODUCT = By.cssSelector("div >a[href='https://keyfood.ro/product/zevia-kidz-strawberry-lemonade-zero-calorie-soda/']");
    public ProductsPage(EnumCategories category){
        SELECTED_CATEGORY = category;
    }
    public ProductPage clickOnProduct(){
        switch (SELECTED_CATEGORY) {
            case FRUITS_AND_VEGETABLES->{
                clickOnElement(MELON_PRODUCT);
            }
            case BREAKFAST_AND_DAIRY->{
                clickOnElement(EGG_BITES_PRODUCT);
            }
            case BEVERAGES->{
                clickOnElement(ZEVIA_PRODUCT);
            }
            case BISCUITS_SNACKS->{
                clickOnElement(SHIMMER_PASTEL_PRODUCT);
            }
        }
        return new ProductPage();
    }

}
