package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyMethods {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public MyMethods() {
    }

    public static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static boolean isVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public static boolean isVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by))).isDisplayed();
    }

    public static boolean isClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled() && wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
    }

    public static boolean isClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(by)).isEnabled() && wait.until(ExpectedConditions.elementToBeClickable(by)).isDisplayed();
    }
    public static void waitForReadyState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }
    public static void waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitForElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    public static void waitForElementToUpdate(By by, String initialText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(by, initialText)));
    }
    public static void waitForElementStaleness(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
    }
    public static void waitForUrlToNotBe(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }
    public static void waitForUrlToBe(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public static void waitForElementNotStaleness(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(by))));
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void sendKeys(By by, String keys) {
        driver.findElement(by).sendKeys(keys);
    }

    public static void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static String getTextFromElement(WebElement element) {
        return element.getText();
    }
    public static List<String> getListOfTextFromElements(List<WebElement> elements) {
        var textList = new ArrayList<String>();
        for (var element: elements) {
            textList.add(getTextFromElement(element));
        }
        return textList;
    }

    public static List<WebElement> elements(By by) {
        return driver.findElements(by);
    }

    public static WebElement element(By by) {
        return driver.findElement(by);
    }

    public static void goBack() {
        driver.navigate().back();
    }
    public static void refreshPage() {
        driver.navigate().refresh();
    }
}
