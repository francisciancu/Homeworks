package Homework21;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static Utils.RandomTextGenerator.generateRandomString;
import static org.testng.Assert.*;



public class Ex1 extends BaseTestKeybooks {

    private static final By BOOK_TITLE = By.cssSelector("a[href='the-son']");
    private static final By REVIEWS_TAB = By.cssSelector("a[href='#tab-reviews']");
    private static final By REVIEWS_CHECKBOX = By.cssSelector("input#wp-comment-cookies-consent");
    private static final By SUBMIT_BUTTON = By.cssSelector("input[name='submit']");
    private static final By FOURTH_STAR = By.cssSelector("a.star-4");
    private static final By TEXT_AREA = By.cssSelector("textarea#comment");
    private static final By NAME_FIELD = By.cssSelector("input#author");
    private static final By EMAIL_FIELD = By.cssSelector("input#email");
    private static final By COMMENT = By.cssSelector("div.comment-text");
    private static final By APPROVAL_TEXT = By.cssSelector("em.woocommerce-review__awaiting-approval");

    @Test
    private void testReview() throws InterruptedException {
        var bookTitle = driver.findElement(BOOK_TITLE);

        assertTrue(isVisible(bookTitle), "Book is not visible");
        assertTrue(isClickable(bookTitle), "Book is not clickable");
        bookTitle.click();

        assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-son/", "URL does not match");

        var reviewsTab = driver.findElement(REVIEWS_TAB);
        assertTrue(isVisible(reviewsTab), "Reviews tab is not visible");
        assertTrue(isClickable(reviewsTab), "Reviews tab is not clickable");
        reviewsTab.click();

        var reviewsCheckbox = driver.findElement(REVIEWS_CHECKBOX);
        assertFalse(reviewsCheckbox.isSelected(), "Checkbox is selected (should not be)");

        var submitButton = driver.findElement(SUBMIT_BUTTON);

        assertTrue(isVisible(submitButton), "Submit button is not visible");
        assertTrue(isClickable(submitButton), "Submit button is not clickable");
        submitButton.click();

        var alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "Please select a rating", "Alert message does not match");
        alert.accept();

        var fourthStar = driver.findElement(FOURTH_STAR);
        assertTrue(isClickable(fourthStar), "Fourth star is not clickable");
        fourthStar.click();

        var textArea = driver.findElement(TEXT_AREA);
        textArea.sendKeys(generateRandomString(10));

        var nameField = driver.findElement(NAME_FIELD);
        nameField.sendKeys(generateRandomString(5));

        var emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(generateRandomString(10)+"@email.com");

        reviewsCheckbox.click();
        assertTrue(reviewsCheckbox.isSelected(), "Checkbox is not selected (should be)");

        submitButton.click();

        Thread.sleep(2000);

        var comment = driver.findElement(COMMENT);
        assertTrue(isVisible(comment), "Comment did not appear");

        var approvalText = driver.findElement(APPROVAL_TEXT);
        assertTrue(isVisible(approvalText), "Approval text is not visible");
        assertEquals(approvalText.getText(), "Your review is awaiting approval", "Approval message does not match");

        System.out.println("Everything works");

    }
}
