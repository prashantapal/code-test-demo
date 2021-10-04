package com.moneybin.mortage.mortagetest2.controller;

import com.moneybin.mortage.mortagetest2.service.MonthlyInstallmentCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculate")
public class InstallmentController {

    @Autowired
    private MonthlyInstallmentCalculator monthlyInstallmentCalculator;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<String>> fetchAllCalculatedInstallment() {
        return ResponseEntity.ok(monthlyInstallmentCalculator.fetchDetailsAndCalculate());
    }
}
