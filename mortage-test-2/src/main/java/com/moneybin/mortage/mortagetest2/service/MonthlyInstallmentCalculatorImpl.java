package com.moneybin.mortage.mortagetest2.service;

import com.moneybin.mortage.mortagetest2.model.Customer;
import com.moneybin.mortage.mortagetest2.repository.CustomerRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.moneybin.mortage.mortagetest2.utils.MathUtil.power;
import static java.util.Collections.emptyList;

@Service
@Transactional(readOnly = true)
public class MonthlyInstallmentCalculatorImpl implements MonthlyInstallmentCalculator {


    private CustomerRepository customerRepository;
    private static Logger logger = LoggerFactory.getLogger(MonthlyInstallmentCalculatorImpl.class);

    @Autowired
    public MonthlyInstallmentCalculatorImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<String> fetchDetailsAndCalculate() {
        List<Customer> customers = customerRepository.findAll();
        if (CollectionUtils.isEmpty(customers)) {
            logger.info("Table does not have any records.........");
            return emptyList();
        }
        return customers.stream()
                .map(this::calculate)
                .collect(Collectors.toList());
    }

    @Override
    public String calculate(Customer customer) {
        try {

            final double monthlyInterest = customer.getInterest() / 100 / 12;
            final int months = customer.getYears() * 12;
            final double emi = (customer.getLoanAmount() * monthlyInterest) / (1 - power(1 + monthlyInterest, -months));
            return customer.getCustomerName() + " wants to borrow " + customer.getLoanAmount() + " € for a period of " + customer.getYears() + " years and pay " + emi + " € each month";
        } catch (Exception ex) {
            logger.error("Error occurred while calculating monthly installment for customer " + customer.toString(), ex);
            throw new RuntimeException(ex);
        }
    }
}
