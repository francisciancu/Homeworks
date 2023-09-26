package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutorUtils {
    private static JavascriptExecutor JS;
    private static final String JAVASCRIPT_HOVER = "var obiect = document.createEvent('MouseEvent');"
            + "obiect.initMouseEvent('mouseover', true);"
            + "arguments[0].dispatchEvent(obiect);";
    private static final String JAVASCRIPT_SCROLL_INTO_VIEW = "arguments[0].scrollIntoView();";

    private static final String JAVASCRIPT_CHECK_VISIBILITY = "return arguments[0].checkVisibility()";
    private static final String JAVASCRIPT_CLICK = "arguments[0].click();";
    private static final String JAVASCRIPT_OFFSET_HEIGHT = "return arguments[0].offsetHeight;";
    private static final String JAVASCRIPT_GET_TEXT = "return arguments[0].innerText;";
    private static final String JAVASCRIPT_SEND_KEYS = "arguments[0].value='";

    public static void initialize(WebDriver driver) {
        JS = (JavascriptExecutor) driver;
    }

    public static void hoverOverElement(WebElement element) {
        JS.executeScript(JAVASCRIPT_HOVER, element);
    }

    public static void clickOnElement(WebElement element) {
        JS.executeScript(JAVASCRIPT_CLICK, element);
    }

    public static Boolean checkVisibilityOfElement(WebElement element) {
        return (Boolean) JS.executeScript(JAVASCRIPT_CHECK_VISIBILITY, element);
    }

    public static void scrollElementIntoView(WebElement element) {
        JS.executeScript(JAVASCRIPT_SCROLL_INTO_VIEW, element);
    }

    public static void moveUpToAvoidStickyElementCovering(WebElement element) {
        var stickyOffset = JS.executeScript(JAVASCRIPT_OFFSET_HEIGHT, element).toString();
        JS.executeScript("window.scrollBy(0,-" + stickyOffset + ")", element);
    }

    public static String getTextOfElement(WebElement element) {
        return JS.executeScript(JAVASCRIPT_GET_TEXT, element).toString();
    }

    public static void sendKeysToField(String text,WebElement element) {
        JS.executeScript(JAVASCRIPT_SEND_KEYS +text+"'",element);
    }
}
