package demo.domainobjects;

public class DressPrice {

    public DressPrice(Double price , String index) {
        this.price = price;
        this.index = index;
    }
    private Double price;
    private String index;

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }


}
