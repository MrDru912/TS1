package lab10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static void jsClick(WebElement element, WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",element);
    }

    public static void fillInUsernameAndPassword(WebElement usernameForm, WebElement passwordForm, WebDriver driver) {

    }
}
