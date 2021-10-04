package com.moneybin.mortage.mortagetest2.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private String customerName;
    private double loanAmount;
    private double interest;
    private int years;
    private double emi;

    public Customer() {

    }

    public Customer(String customerName, double loanAmount, double interest, int years, double emi) {
        this.customerName = customerName;
        this.loanAmount = loanAmount;
        this.interest = interest;
        this.years = years;
        this.emi = emi;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", loanAmount=" + loanAmount +
                ", interest=" + interest +
                ", years=" + years +
                '}';
    }
}
