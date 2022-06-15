package demo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumUtils {

    public void MouseHover(WebElement element , WebDriver driver){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public void ScrollIntoView(WebElement element , WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
