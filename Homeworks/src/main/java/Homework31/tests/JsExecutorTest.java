package Homework31.tests;

import Homework31.pages.GalleryFormatPage;
import Homework31.pages.MenuPage;
import Homework31.pages.PostFormatsPage;
import KeyBooksDriver.BaseTestKeybooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsExecutorTest extends BaseTestKeybooks {
    @Test
    public void JsExecTest() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToPostFormats();

        PostFormatsPage postFormatsPage = new PostFormatsPage(driver);
        Assert.assertTrue(postFormatsPage.checkVisibilityOfTitle());
        postFormatsPage.scrollTitleIntoView();
        //puteam sa fac si in asa fel inca sa scad din distanta pe care o am pana la element distanta de la sticky si
        //dupa sa mut cu diferenta dintre ele. banuiesc ca avem acelasi rezultat, dar am zis ca il complic prea mult
        postFormatsPage.moveToAvoidSticky();
        postFormatsPage.clickOnGalleryFormat();

        GalleryFormatPage galleryFormatPage = new GalleryFormatPage(driver);
        Assert.assertEquals( galleryFormatPage.getTitleText(),"GALLERY FORMAT");
        galleryFormatPage.postComment();
        Assert.assertTrue(galleryFormatPage.checkVisibilityOfComment());
        Assert.assertTrue(galleryFormatPage.checkVisibilityOfAuthor());
        Assert.assertEquals(driver.findElement(galleryFormatPage.COMMENT_TEXT_ELEMENT).getText(),galleryFormatPage.VALUES_MAP.get("commentText"));
        Assert.assertEquals(driver.findElement(galleryFormatPage.AUTHOR_TEXT_ELEMENT).getText(),galleryFormatPage.VALUES_MAP.get("author"));
        System.out.println("Everything works as expected");
    }
}