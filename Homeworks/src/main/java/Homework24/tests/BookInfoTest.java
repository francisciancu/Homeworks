package Homework24.tests;

import Homework24.pages.BookPage;
import Homework24.pages.MenuPage;
import Homework24.pages.ShopPage;
import KeyBooksDriver.BaseTestKeybooks;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookInfoTest extends BaseTestKeybooks {

    @Test(priority = 1)
    public void checkBookInfo(){
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(driver.findElement(menuPage.SHOP_LINK));
        ShopPage shopPage = new ShopPage(driver);

        //Posibil sa pice pentru ca alege o carte la intamplare din cele de pe pagina si nu toate cartile au tot ce le trebuie - rating de exemplu

        //am sa las ambele variante (ca sa fie si o varianta in care se vede ca merge)
        shopPage.clickOnChosenBook();
        //shopPage.clickOnRandomBook(); <- asta e varianta in care face lista de carti si da pe una la intamplare si care e posibil sa pice in functie de norocul cand alege o carte

        BookPage bookPage = new BookPage(driver);

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_SEARCH_ICON),
                "Search icon is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_TITLE),
                "Book title is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_RATING),
                "Book rating is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_PRICE),
                "Book price is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_DESCRIPTION),
                "Book description is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_QUANTITY),
                "Book quantity is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.ADD_TO_CART_BUTTON),
                "Add to cart button is not displayed");

        assertTrue(bookPage.checkIfElementIsDisplayed(bookPage.BOOK_INFO),
                "Book info is not displayed");

        System.out.println("Everything works as expected");
    }
}
