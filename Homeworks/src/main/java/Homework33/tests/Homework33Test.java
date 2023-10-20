package Homework33.tests;

import Homework33.pages.BookPage;
import Homework33.pages.MenuPage;
import KeyDriver.BaseTestKeybooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework33Test extends BaseTestKeybooks {
    @Test(priority = 1 , description = "Test 1")
    public void test1Homework33(){
        MenuPage menuPage = new MenuPage(driver);
        menuPage.searchForBook();
        menuPage.openBookPage();

        BookPage bookPage = new BookPage(driver);

        Assert.assertEquals(getCurrentUrl(),bookPage.EXPECTED_BOOK_URL);
        Assert.assertEquals(bookPage.getBookCategory(),bookPage.EXPECTED_BOOK_CATEGORY);
        Assert.assertEquals(bookPage.getBookProductId(),bookPage.EXPECTED_BOOK_PRODUCT_ID);
        Assert.assertTrue(bookPage.checkAllBookImg());

    }

}
