package Homework34.pages;

import KeyBooksDriver.BaseTestKeyFood;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static Utils.MyMethods.clickOnElement;
import static Utils.MyMethods.elements;

public class MainPage extends BaseTestKeyFood {
    private static final By CATEGORIES_TITLE = By.cssSelector("div.category-detail > h3 > a");
    private static final By CATEGORIES = By.cssSelector("div.category.slick-active");
    private static final By ACCOUNT_BUTTON = By.linkText("My account");

    public MainPage() {
    }

    public LoginPage clickOnAccountToLogin() {
        clickOnElement(ACCOUNT_BUTTON);
        return new LoginPage();
    }

    private WebElement getRandomCategory() {
        var categories = elements(CATEGORIES);
        var minIndex = Integer.parseInt(categories.get(1).getAttribute("data-slick-index"));
        var maxIndex = Integer.parseInt(categories.get(categories.size() - 1).getAttribute("data-slick-index"));
        return categories.get(new Random().nextInt(minIndex, maxIndex)).findElement(CATEGORIES_TITLE);
    }

    public ProductsCategoriesPage clickOnCategory() {
        clickOnElement(getRandomCategory());
        return new ProductsCategoriesPage();
    }
}
