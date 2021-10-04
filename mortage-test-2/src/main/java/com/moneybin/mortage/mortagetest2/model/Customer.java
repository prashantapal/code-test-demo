package com.moneybin.mortage.mortagetest2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    @Column(name = "loan_amount", nullable = false)
    private double loanAmount;
    @Column(name = "interest", nullable = false)
    private double interest;
    @Column(name = "years", nullable = false)
    private int years;

    public Customer() {
        super();
    }

    public Customer(Long customerId, String customerName, double loanAmount, double interest, int years) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.loanAmount = loanAmount;
        this.interest = interest;
        this.years = years;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
