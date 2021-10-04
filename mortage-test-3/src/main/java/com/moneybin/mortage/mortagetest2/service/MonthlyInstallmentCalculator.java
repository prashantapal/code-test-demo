package com.moneybin.mortage.mortagetest2.service;

import com.moneybin.mortage.mortagetest2.model.Customer;

import java.util.List;

public interface MonthlyInstallmentCalculator {

    Customer calculate(Customer customer);
}
