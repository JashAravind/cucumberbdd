package demo.pages;

import demo.domainobjects.DressPrice;
import demo.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CartPage extends BasePage{
    @FindBy(css = "a[title='Proceed to checkout']") private WebElement proceedToCheckOutBtn;
    @FindBy(css = "#total_product") private WebElement priceInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProceedToCheckout(String categoryName) {
        switch(categoryName) {
            case "proccedtoCheckout":
                wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutBtn)).click();
                break;
        }
    }
    public Double getPriceFromCart(){
        Double cartPrice = Double.parseDouble(wait.until(ExpectedConditions.visibilityOf(priceInCart)).getText().replace("$","").trim());
        return  cartPrice;
    }
}
