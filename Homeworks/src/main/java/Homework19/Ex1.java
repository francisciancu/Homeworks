package Homework19;


import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTestKeybooks {
    public static final By THE_FOREST_BOOK = By.cssSelector("a[href='the-forest']");
    public static final By TITLES = By.cssSelector("li.sc_tabs_title");

    @Test(description = "Check if book appears in all categories and the redirect link works")
    public static void secondTest() throws InterruptedException {

        var titlesList = driver.findElements(TITLES);
        var forestBook = driver.findElements(THE_FOREST_BOOK);

        for (int i = 0; i < titlesList.size(); i++) {
            titlesList.get(i).click();
            Thread.sleep(3000);
            assertTrue(forestBook.get(i).isDisplayed(), "The Forest book is not displayed");

            if (i == (titlesList.size() - 1)) {
                forestBook.get(i).click();
                Thread.sleep(2000);
                assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/",
                        "Nu am ajuns pe https://keybooks.ro/shop/the-forest/");

            }
        }

        System.out.println("Everything works as expected");

    }
}
