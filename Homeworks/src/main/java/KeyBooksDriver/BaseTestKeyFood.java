package KeyBooksDriver;

import Utils.DriverSingleton;
import Utils.MyMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTestKeyFood {
    public static WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        driver = DriverSingleton.getDriver();
        MyMethods.setWebDriver(driver);
        driver.get("https://keyfood.ro/");
    }

    @AfterClass
    public void tearDownDriver() {
        DriverSingleton.closeDriver();
    }
}
