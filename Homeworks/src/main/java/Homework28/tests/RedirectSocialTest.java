package Homework28.tests;

import Homework28.pages.MenuPage;
import KeyBooksDriver.BaseTestKeybooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class RedirectSocialTest extends BaseTestKeybooks {
    @Test
    public void redirectSocialTest() {
        MenuPage menuPage = new MenuPage(driver);
        String keyBooksHandle = driver.getWindowHandle();

        var facebookRedirectLink = menuPage.getHrefString(driver.findElement(menuPage.FACEBOOK_ANCHOR));
        var twitterRedirectLink = menuPage.getHrefString(driver.findElement(menuPage.TWITTER_ANCHOR));
        var instagramRedirectLink = menuPage.getHrefString(driver.findElement(menuPage.INSTAGRAM_ANCHOR));

        menuPage.clickOnElement(driver.findElement(menuPage.FACEBOOK_ICON));
        menuPage.clickOnElement(driver.findElement(menuPage.INSTAGRAM_ICON));
        menuPage.clickOnElement(driver.findElement(menuPage.TWITTER_ICON));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Set<String> allHandles = driver.getWindowHandles();
        allHandles.remove(keyBooksHandle);

        // nu prea imi place cum a iesit (nu stiu daca mai e inca o varianta mai buna). am incercat sa ma gandesc la alte variante si ca fac un map cu
        // raspunsurile si in loc de cele 3 if uri sa am un for care parcurge acel map si vede daca corespund chestii
        // dar asa am zis ca nu am garantia ca verifit toate cele 3 site uri ( eu acum fac cu boolean ul ala sa vad ca
        // sigur am verificat toate 3 site urile ). alta varianta m am gandit ca pot sa profit
        // de .remove si sa fac ceva de genul deschid o pagina noua -> getWindowHandles() -> .remove la handle pe care le
        // stiu/am -> raman cu 1 handle si ala e de la pagina nou deschisa -> repeat pentru fiecare pagina noua ->
        // variabile cu fiecare handle. dar mi se pare ca se complica prea mult si repeti foreach (sau alternative) ca sa
        // poti sa intri in set si dupa repeti .remove  de 1 sau mai multe ori in fucntie de cate brei sa scoti ca sa
        // ramai cu ala noua
        // mai e si varianta sa deschid cate o pagina pe rand verific pagina inchid deschid alta repeat
        // da tot tre sa repet foreach pentru set ul de handlers ca sa nu intru pe keybooks

        var facebookChecked = false;
        var instagramChecked = false;
        var twitterChecked = false;

        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));

            if (driver.getTitle().contains("Facebook")) {
                Assert.assertEquals(driver.getCurrentUrl(), facebookRedirectLink, "Not checked expected tab");
                facebookChecked = true;

            } else if (driver.getTitle().contains("Instagram")) {
                Assert.assertEquals(driver.getCurrentUrl(), instagramRedirectLink, "Not checked expected tab");
                instagramChecked = true;

            } else if (driver.getTitle().contains("X")) {
                Assert.assertEquals(driver.getCurrentUrl(), twitterRedirectLink, "Not checked expected tab");
                twitterChecked = true;
            }
            driver.close();

        }
        Assert.assertTrue(facebookChecked && twitterChecked && instagramChecked, "Not all redirects were checked");
        driver.switchTo().window(keyBooksHandle);
    }
}
