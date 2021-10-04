package com.moneybin.mortage.mortagetest2.repository;

import com.moneybin.mortage.mortagetest2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
