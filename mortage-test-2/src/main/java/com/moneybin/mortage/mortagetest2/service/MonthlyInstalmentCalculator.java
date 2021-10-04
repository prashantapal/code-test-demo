package com.moneybin.mortage.mortagetest2.service;

import java.util.Optional;

public interface MonthlyInstalmentCalculator {
    Optional<String> calculate(String eachLine);
}
