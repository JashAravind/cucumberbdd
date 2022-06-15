package demo.pages;

import demo.context.TestContext;
import demo.domainobjects.DressPrice;
import demo.utils.SeleniumUtils;
import demo.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StorePage extends BasePage{
    @FindBy(css = ".product-container > .right-block > .content_price > .price.product-price") private List<WebElement> contentPrice;
    @FindBy(css = ".product-container > .right-block > .button-container > a[title='Add to cart']") private List<WebElement> addToCartBtn;
    public StorePage(WebDriver driver ) {
        super(driver);
    }

    public void clickCategory(String categoryName){
        String menuLocator = ".cat-title+ul > li > a[title='" + categoryName + "']";
        String menuLocatorEncoded = new StringUtils().getUtf8Encoded(menuLocator);
        By clickMenuBtn = By.cssSelector(menuLocatorEncoded);
        wait.until(ExpectedConditions.elementToBeClickable(clickMenuBtn)).click();
    }

    public DressPrice addHighestPriceItemToCart(){
        List<DressPrice> storePrice = getDressPrices();
        DressPrice maxPrice = getMaxPrice(storePrice);
        WebElement element = contentPrice.get(Integer.parseInt(maxPrice.getIndex()));
        new SeleniumUtils().ScrollIntoView(element,driver);
        new SeleniumUtils().MouseHover(element,driver);
        addToCartBtn.get(Integer.parseInt(maxPrice.getIndex())).click();
        return maxPrice;
    }

    private DressPrice getMaxPrice(List<DressPrice> storePrice) {
        DressPrice maxPrice = storePrice.stream()
                .max(Comparator.comparingDouble(DressPrice::getPrice))
                .get();
        return maxPrice;
    }

    private List<DressPrice> getDressPrices() {
        int index = 0;
        List<DressPrice> storePrice = new ArrayList<>();
        for(WebElement element : contentPrice) {
            Double price = Double.parseDouble(element.getText().replace("$","").trim());
            String elementIndex = String.valueOf(index);
            storePrice.add(new DressPrice(price,elementIndex));
            index++;
        }
        return storePrice;
    }

}
