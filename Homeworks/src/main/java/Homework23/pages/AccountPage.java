package Homework23.pages;

import KeyDriver.BaseTestKeybooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BaseTestKeybooks {

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By ADDRESSES_TEXT = By.linkText("Addresses");
    public By ADD_BUTTON_FOR_SHIPPING_ADDRESS_TEXT = By.cssSelector("a[href='https://keybooks.ro/account/edit-address/shipping/']");

    public void navigateToShippingAddress() {
        driver.findElement(ADDRESSES_TEXT).click();
        driver.findElement(ADD_BUTTON_FOR_SHIPPING_ADDRESS_TEXT).click();
    }
}
