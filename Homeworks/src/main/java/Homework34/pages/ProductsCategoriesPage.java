package Homework34.pages;

import KeyBooksDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Random;

import static Utils.MyMethods.*;

public class ProductsCategoriesPage extends BaseTestKeyFood {
    private static final By PRODUCTS_TITLES = By.cssSelector("main#main h3.product-title > a");
    private static final String EXPECTED_URL = "https://keyfood.ro/product-category/";

    public ProductsCategoriesPage() {
    }

    private WebElement getRandomProduct() {
        var productsTitles = elements(PRODUCTS_TITLES);
        var chosen = new Random().nextInt(productsTitles.size());
        return productsTitles.get(chosen);
    }

    public ProductPage clickOnProduct() {
        var product = getRandomProduct();
        clickOnElement(product);
        return new ProductPage();
    }

    public ProductsCategoriesPage checkIfOnProductsCategoriesPage() {
        Assert.assertTrue(getCurrentUrl().contains(EXPECTED_URL));
        return this;
    }
}
