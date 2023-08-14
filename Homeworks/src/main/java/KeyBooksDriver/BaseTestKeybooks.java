package KeyBooksDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestKeybooks {
    public static WebDriver driver;
    @BeforeClass
    public void setupDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://keybooks.ro/");

    }
    @AfterClass
    public void tearDownDriver(){
        driver.close();
    }

}
