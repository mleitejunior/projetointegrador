package model;

public class Product {
    int id;
    String name;
    float cost;
    float percentProfit;
    float productExpense;
    float priceSale;
    int quantity;
    int idProvider;

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

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

    public float getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(float productExpenses) {
        this.productExpense = productExpenses;
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
