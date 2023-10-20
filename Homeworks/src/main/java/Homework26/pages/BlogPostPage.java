package Homework26.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlogPostPage extends BaseTestKeybooks {
    public WebDriver driver;
    public By POST_CATEGORIES = By.cssSelector("div:not(.post_info_bottom) > span.post_info_tags > a");
    public List<String> EXPECTED_CATEGORIES = Arrays.asList("Classic", "News", "Recommend");

    public BlogPostPage(WebDriver driver) {
        this.driver = driver;
    }

    private List<String> getCategoriesText(List<WebElement> listOfElements) {
        List<String> listOfText = new ArrayList<>();
        for (WebElement element : listOfElements) {
            listOfText.add(element.getText());
        }
        return listOfText;
    }

    public boolean checkCategories(List<WebElement> element, List<String> listOfExpectedElements) {
        var listOfActualElements = getCategoriesText(element);
        if (listOfExpectedElements.size() != listOfActualElements.size()) {
            return false;
        }
        Collections.sort(listOfActualElements);
        Collections.sort(listOfExpectedElements);
        return listOfActualElements.equals(listOfExpectedElements);
    }
}
