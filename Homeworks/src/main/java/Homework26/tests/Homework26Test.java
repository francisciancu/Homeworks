package Homework26.tests;

import Homework26.pages.*;
import KeyDriver.BaseTestKeybooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework26Test extends BaseTestKeybooks {

    @Test(priority = 1)
    public void test1() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToClassics();
        Assert.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/category/classic/");

        ClassicsPage classicsPage = new ClassicsPage(driver);
        classicsPage.searchText(classicsPage.SEARCHED_TEXT);
        Assert.assertTrue(classicsPage.checkBookPresence(driver.findElement(classicsPage.POST_TITLE)));
        classicsPage.clickOnPost(driver.findElement(classicsPage.POST_TITLE));

        BlogPostPage blogPostPage = new BlogPostPage(driver);
        Assert.assertTrue(blogPostPage.checkCategories
                (driver.findElements(blogPostPage.POST_CATEGORIES), blogPostPage.EXPECTED_CATEGORIES));

        System.out.println("Everything works as expected - test 1");
    }

    @Test(priority = 2)
    public void test2() {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToBooks();
        Assert.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");

        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToCookingBooksCategory();
        Assert.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/product-category/cookbooks/");

        CookingBooksPage cookingBooksPage = new CookingBooksPage(driver);
        Assert.assertEquals(cookingBooksPage.getSizeOfList(driver.findElements(cookingBooksPage.ON_SALE_PATCH)),
                cookingBooksPage.getSizeOfList(driver.findElements(cookingBooksPage.ALL_BOOKS)),
                "Not all books are on sale.");

        System.out.println("Everything works as expected - test 2");
    }
}
