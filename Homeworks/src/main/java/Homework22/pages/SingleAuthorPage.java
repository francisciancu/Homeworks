package Homework22.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingleAuthorPage extends BaseTestKeybooks {
    public WebDriver driver;
    public By DRAMA_SKILL = By.cssSelector("div.sc_skills_item.first > div > div.sc_skills_total");
    public By BIOGRAPHY_SKILL = By.cssSelector("div.sc_skills_item.even > div > div.sc_skills_total");
    public By COOKBOOKS_SKILL = By.cssSelector("div.sc_skills_item.odd:not(.first) > div > div.sc_skills_total");

    public SingleAuthorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getDramaSkill() {

        var dramaSkill = driver.findElement(DRAMA_SKILL);
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dramaSkill));

        return dramaSkill.getText();
    }

    public String getBiographySkill() {

        var biographySkill = driver.findElement(BIOGRAPHY_SKILL);
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(biographySkill));

        return biographySkill.getText();
    }

    public String getCookbooksSkill() {

        var cookbooksSkill = driver.findElement(COOKBOOKS_SKILL);
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cookbooksSkill));

        return cookbooksSkill.getText();
    }

    public boolean checkSkillValue(String actualValue, String expectedValue) {

        return actualValue.equals(expectedValue);
    }
}
