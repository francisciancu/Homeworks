package Homework22.tests;

import Homework22.pages.MenuPage;
import Homework22.pages.SingleAuthorPage;
import KeyBooksDriver.BaseTestKeybooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SingleAuthorTest extends BaseTestKeybooks {

    @Test(priority = 1)
    public void checkSkillValue() {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(menuPage.SINGLE_AUTHOR);
        SingleAuthorPage singleAuthorPage = new SingleAuthorPage(driver);

        assertTrue(singleAuthorPage.checkSkillValue(singleAuthorPage.getDramaSkill()
                , "95%"), "Not the expected value for Drama Skill");

        assertTrue(singleAuthorPage.checkSkillValue(singleAuthorPage.getBiographySkill()
                , "75%"), "Not the expected value for Biography Skill");

        assertTrue(singleAuthorPage.checkSkillValue(singleAuthorPage.getCookbooksSkill()
                , "82%"), "Not the expected value for Cookbooks Skill");


        System.out.println("Everything works as expected");
    }
}
