package Homework19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 {
    public static final By THE_FOREST_BOOK = By.cssSelector("a[href='the-forest']");
    public static final By TITLES = By.cssSelector("li.sc_tabs_title");
    static WebDriver driver = new ChromeDriver();

    @Test
    public static void secondTest() throws InterruptedException {
        driver.get("https://keybooks.ro/");
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
        driver.close();

    }
}
