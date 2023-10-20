package Homework23.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage extends BaseTestKeybooks {

    public WebDriver driver;
    public By COUNTRY_REGION = By.cssSelector("select#shipping_country");
    public By PROVINCE = By.cssSelector("select#shipping_state");


    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
    }
    public void countryRegionSelect(int index){
        WebElement countryRegionDropdown =  driver.findElement(COUNTRY_REGION);
        Select select = new Select(countryRegionDropdown);
        select.selectByIndex(index);
    }
    public void provinceSelect(String value){
        WebElement dropdown =  driver.findElement(PROVINCE);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public String getSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

}
