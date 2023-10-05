package Homework32.tests;

import Homework32.pages.BookPage;
import Homework32.pages.MenuPage;
import KeyBooksDriver.BaseTestKeybooks;
import Utils.DataProviderClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuPageBooksTest extends BaseTestKeybooks {

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "booksSelectorsAndLinks")
    public void MenuBooksTest(String bookCssSelector, String expectedBookLink) {
        MenuPage menuPage = new MenuPage(driver);
        BookPage bookPage = new BookPage(driver);

        menuPage.clickOnBook(driver.findElement(By.cssSelector(bookCssSelector)));
        Assert.assertEquals(bookPage.getBookLink(), expectedBookLink);
        bookPage.goBackToMenuPage();
        Assert.assertEquals(menuPage.getMenuPageUrl(), menuPage.MENU_PAGE_URL);

    }
}
