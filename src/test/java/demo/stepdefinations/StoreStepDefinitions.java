package demo.stepdefinations;

import demo.context.TestContext;
import demo.domainobjects.Category;
import demo.domainobjects.ProductPrice;
import demo.pages.PageFactoryManager;
import demo.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;
    private final TestContext context;


    public StoreStepDefinitions(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }
    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        storePage.load();
    }


    @When("I click on {category} from top menu")
    public void iClickCategory(Category category) {
        storePage.clickCategory(category.getName());
    }


    @And("I add {price} price dress item to cart")
    public void iHaveAProductInTheCart(ProductPrice price) {
        context.price = storePage.addHighestPriceItemToCart();
    }
}
