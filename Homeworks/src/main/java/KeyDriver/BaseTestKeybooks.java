package KeyDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

public class BaseTestKeybooks{
    public static WebDriver driver;


    @BeforeClass
    public void setupDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://keybooks.ro/");

    }
    @AfterClass
    public void tearDownDriver(){
        driver.quit();
    }

    public boolean isVisible(WebElement element){
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public boolean isClickable(WebElement element){
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled() && wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
    }

    public void clickOnElement(WebElement element){
        element.click();
    }
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public void sendKeys(By by,String keys){
        driver.findElement(by).sendKeys(keys);
    }
    public void sendKeys(WebElement element,String keys){
        element.sendKeys(keys);
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public String getTextFromElement(WebElement element){
        return element.getText();
    }
    public List<WebElement> elements (By by){
        return driver.findElements(by);
    }
    public void goBack(){
        driver.navigate().back();
    }


}
