package demo.domainobjects;

public class ProductPrice {
    public ProductPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    private String price;
}
