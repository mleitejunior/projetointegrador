package model;

public class Product {
    int id;
    String name;
    float cost;
    float percentProfit;
    float productExpenses;
    float priceSale;
    int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPercentProfit() {
        return percentProfit;
    }

    public void setPercentProfit(float percentProfit) {
        this.percentProfit = percentProfit;
    }

    public float getProductExpenses() {
        return productExpenses;
    }

    public void setProductExpenses(float productExpenses) {
        this.productExpenses = productExpenses;
    }

    public float getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(float priceSale) {
        this.priceSale = priceSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
