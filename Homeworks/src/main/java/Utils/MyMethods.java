package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMethods {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(MyMethods.class);

    public MyMethods() {
    }

    public static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static boolean isVisible(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public static boolean isVisible(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(by))).isDisplayed();
    }

    public static boolean isClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element)).isEnabled() && new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
    }

    public static boolean isClickable(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by)).isEnabled() && new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by)).isDisplayed();
    }

    public static void waitForReadyState() {

        try {
            logger.info("Waiting for ready state");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void waitForElementToBeClickable(By by) {
        try {
            logger.info("Waiting for element with selector [ " + by + " ] to be clickable");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }

    }

    public static void waitForElementToBeVisible(By by) {
        try {
            logger.info("Waiting for element with selector [ " + by + " ] to be visible");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }

    }

    public static void waitForElementToUpdate(By by, String initialText) {
        try {
            logger.info("Waiting for element with selector [ " + by + " ] text to not be [ " + initialText + " ]");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.textToBe(by, initialText)));
        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void waitForElementStaleness(By by) {
        try {
            logger.info("Waiting for staleness of element with selector [ " + by + " ]");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.stalenessOf(driver.findElement(by)));
        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }

    }

    public static void waitForUrlToNotBe(String url) {
        try {
            logger.info("Waiting for URL to not be [ " + url + " ]");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void waitForUrlToBe(String url) {
        try {
            logger.info("Waiting for URL to be [ " + url + " ]");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void waitForElementNotStaleness(By by) {
        try {
            logger.info("Waiting for not staleness of element with selector [ " + by + " ]");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(by))));
        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Successfully clicked on element [ " + element + " ]");
        } catch (NoSuchElementException e) {
            logger.error("Element [ " + element + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void clickOnElement(By by) {

        try {
            driver.findElement(by).click();
            logger.info("Successfully clicked on element with selector [ " + by + " ]");
        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void sendKeys(By by, String keys) {
        logger.info("Trying to send keys: " + keys + " to element [ " + by + " ]");
        try {
            var inputField = driver.findElement(by);
            inputField.sendKeys(keys);
            if (inputField.getAttribute("type").equals("password")) {
                logger.info("Successfully sent password " + "*".repeat(new Random().nextInt((5) + 5)) + " to element [ " + by + " ]");
            } else {
                logger.info("Successfully sent keys: " + keys + " to element [ " + by + " ]");
            }

        } catch (NoSuchElementException e) {
            logger.error("Element [ " + by + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void sendKeys(WebElement element, String keys) {
        logger.info("Trying to send keys: " + keys + " to element [ " + element + " ]");
        try {
            element.sendKeys(keys);
            logger.info("Successfully sent keys: " + keys + " to element [ " + element + " ]");
        } catch (NoSuchElementException e) {
            logger.error("Element [ " + element + " ] not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }

    }

    public static String getCurrentUrl() {
        logger.info("Trying to get current URL");
        try {
            var currentUrl = driver.getCurrentUrl();
            logger.info("Successfully got current URL");
            return currentUrl;

        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            return null;
        }
    }


    public static String getTextFromElement(By by) {
        logger.info("Trying to get text form element with selector [ " + by + " ]");
        try {
            var elementText = driver.findElement(by).getText();
            logger.info("Successfully got text form element with selector [ " + by + " ]");
            return elementText;

        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static String getTextFromElement(WebElement element) {
        var elementSelector = extractElementSelector(element);
        logger.info("Trying to get text form element with selector [ " + elementSelector + " ]");
        try {
            var elementText = element.getText();
            logger.info("Successfully got text form element with selector[ " + elementSelector + " ]");
            return elementText;

        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + elementSelector + " ] not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static List<String> getListOfTextFromElements(List<WebElement> elements) {
        var elementSelectors = extractElementSelectors(elements);
        logger.info("Trying to get text form list of elements with selector [ " + elementSelectors + " ]");
        try {
            var textList = new ArrayList<String>();
            for (var element : elements) {
                textList.add(getTextFromElement(element));
            }
            logger.info("Successfully got text form list of elements with selector[ " + elementSelectors + " ]");
            return textList;

        } catch (NoSuchElementException e) {
            logger.error("Elements with selector [ " + elementSelectors + " ] not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static List<WebElement> elements(By by) {
        logger.info("Trying to get elements with selector [ " + by + " ]");
        try {
            var elements = driver.findElements(by);
            logger.info("Successfully got elements with selector [ " + by + " ]");
            return elements;

        } catch (NoSuchElementException e) {
            logger.error("Elements with selector [ " + by + " ] not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static WebElement element(By by) {
        logger.info("Trying to get element with selector [ " + by + " ]");
        try {
            var element = driver.findElement(by);
            logger.info("Successfully got element with selector [ " + by + " ]");
            return element;

        } catch (NoSuchElementException e) {
            logger.error("Element with selector [ " + by + " ] not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static void goBack() {
        logger.info("Trying to got back 1 time");
        try {
            driver.navigate().back();
            logger.info("Successfully went back 1 time");
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static void refreshPage() {
        logger.info("Trying to refresh page 1 time");
        try {
            driver.navigate().refresh();
            logger.info("Successfully refreshed page 1 time");
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static String extractElementSelector(WebElement element) {
        String elementSelector = element.toString();
        return elementSelector.replaceAll(".*? -> (.+?)]", "$1");
    }

    public static List<String> extractElementSelectors(List<WebElement> elements) {
        List<String> selectors = new ArrayList<>();
        for (WebElement element : elements) {
            selectors.add(extractElementSelector(element));
        }
        return selectors;
    }
}
