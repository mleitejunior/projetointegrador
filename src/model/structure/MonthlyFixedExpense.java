package model.structure;

import java.util.Date;

public class MonthlyFixedExpense {
    private Date date;
    private Double useMaterial;
    private Double equipment;
    private Double monthlyTax;
    private Double rent;
    private Double loan;
    private Double maintenance;
    private Double employees;
    private Double others;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getUseMaterial() {
        return useMaterial;
    }

    public void setUseMaterial(Double useMaterial) {
        this.useMaterial = useMaterial;
    }

    public Double getEquipment() {
        return equipment;
    }

    public void setEquipment(Double equipment) {
        this.equipment = equipment;
    }

    public Double getMonthlyTax() {
        return monthlyTax;
    }

    public void setMonthlyTax(Double monthlyTax) {
        this.monthlyTax = monthlyTax;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Double maintenance) {
        this.maintenance = maintenance;
    }

    public Double getEmployees() {
        return employees;
    }

    public void setEmployees(Double employees) {
        this.employees = employees;
    }

    public Double getOthers() {
        return others;
    }

    public void setOthers(Double others) {
        this.others = others;
    }
}
