package model.entities;

import java.util.Date;
import model.structure.Tax;
import model.structure.Discount;

public class Sale {
    private Integer idSale;
    private Date date;
    private Double netValue;
    private Integer clientIdClient;
    private Integer userIdUser;
    private String clientName;
    private String userName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Integer getClientIdClient() {
        return clientIdClient;
    }

    public void setClientIdClient(Integer clientIdClient) {
        this.clientIdClient = clientIdClient;
    }

    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }
    
    

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer id) {
        this.idSale = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    private Enum type;
    private Discount discount;
    private Tax tax;
    private Product products[];
}
