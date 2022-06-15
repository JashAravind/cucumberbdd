package demo.stepdefinations;

import demo.context.TestContext;
import demo.domainobjects.Category;
import demo.domainobjects.ProductPrice;
import demo.domainobjects.ShoppingExperience;
import demo.pages.CartPage;
import demo.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;
    private final TestContext context;
    public CartStepDefinitions(TestContext context){
        this.context = context;
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @And("I click on {action} on shopping cart")
    public void iClickOnProceedToCheckOut(ShoppingExperience action) {
        cartPage.clickOnProceedToCheckout(action.getAction());
    }

    @Then("Max price should be visible in cart")
    public void verifyMaxiumPrice() {
        Assert.assertEquals(cartPage.getPriceFromCart(),context.price.getPrice());
    }
}
