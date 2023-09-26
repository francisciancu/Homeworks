package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Utils.RandomTextGenerator.generateRandomString;

public class JsExecutorUtils {
    private static JavascriptExecutor js;
    private static final String javascriptHover = "var obiect = document.createEvent('MouseEvent');"
            + "obiect.initMouseEvent('mouseover', true);"
            + "arguments[0].dispatchEvent(obiect);";
    private static final String javascriptScrollIntoView = "arguments[0].scrollIntoView();";

    private static final String javascriptCheckVisibility = "return arguments[0].checkVisibility()";
    private static final String javascriptClick = "arguments[0].click();";
    private static final String javascriptOffsetHeight = "return arguments[0].offsetHeight;";
    private static final String javascriptGetText = "return arguments[0].innerText;";
    private static final String javascriptSendKeys = "arguments[0].value='";

    public static void initialize(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    public static void hoverOverElement(WebElement element) {
        js.executeScript(javascriptHover, element);
    }

    public static void clickOnElement(WebElement element) {
        js.executeScript(javascriptClick, element);
    }

    public static Boolean checkVisibilityOfElement(WebElement element) {
        return (Boolean) js.executeScript(javascriptCheckVisibility, element);
    }

    public static void scrollElementIntoView(WebElement element) {
        js.executeScript(javascriptScrollIntoView, element);
    }

    public static void moveUpToAvoidStickyElementCovering(WebElement element) {
        var stickyOffset = js.executeScript(javascriptOffsetHeight, element).toString();
        js.executeScript("window.scrollBy(0,-" + stickyOffset + ")", element);
    }

    public static String getTextOfElement(WebElement element) {
        return js.executeScript(javascriptGetText, element).toString();
    }

    public static void sendKeysToField(String text,WebElement element) {
        js.executeScript(javascriptSendKeys +text+"'",element);
    }
}
