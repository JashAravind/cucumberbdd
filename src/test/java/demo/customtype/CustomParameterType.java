package demo.customtype;

import demo.domainobjects.Category;
import demo.domainobjects.ProductPrice;
import demo.domainobjects.ShoppingExperience;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Category category(String name){
        return new Category(name.replace("\"", ""));
    }

    @ParameterType(".*")
    public ProductPrice price(String price){
        return new ProductPrice(price.replace("\"", ""));
    }

    @ParameterType(".*")
    public ShoppingExperience action(String action){
        return new ShoppingExperience(action.replace("\"", ""));
    }
}
