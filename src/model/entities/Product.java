package model.entities;

public class Product {
    private Integer id;
    private String name;
    private Double cost;
    private Double percentProfit;
    private Double productExpense;
    private Double priceSale;
    private Integer quantity;
    private Integer idProvider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPercentProfit() {
        return percentProfit;
    }

    public void setPercentProfit(Double percentProfit) {
        this.percentProfit = percentProfit;
    }

    public Double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(Double productExpense) {
        this.productExpense = productExpense;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
    }
}
