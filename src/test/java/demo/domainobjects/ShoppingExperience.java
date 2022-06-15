package demo.domainobjects;

public class ShoppingExperience {

    public ShoppingExperience(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    private String action;
}
