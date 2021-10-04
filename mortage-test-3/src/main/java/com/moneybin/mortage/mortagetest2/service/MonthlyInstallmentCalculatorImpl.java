package com.moneybin.mortage.mortagetest2.service;

import com.moneybin.mortage.mortagetest2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.moneybin.mortage.mortagetest2.utils.MathUtil.power;

@Service
public class MonthlyInstallmentCalculatorImpl implements MonthlyInstallmentCalculator {

    private static Logger logger = LoggerFactory.getLogger(MonthlyInstallmentCalculatorImpl.class);

    @Override
    public Customer calculate(Customer customer) {
        try {

            final double monthlyInterest = customer.getInterest() / 100 / 12;
            final int months = customer.getYears() * 12;
            final double emi = (customer.getLoanAmount() * monthlyInterest) / (1 - power(1 + monthlyInterest, -months));
            return new Customer(customer.getCustomerName(), customer.getLoanAmount(), customer.getInterest(), customer.getYears(), emi);
        } catch (Exception ex) {
            logger.error("Error occurred while calculating monthly installment for customer " + customer.toString(), ex);
            throw new RuntimeException(ex);
        }
    }
}
