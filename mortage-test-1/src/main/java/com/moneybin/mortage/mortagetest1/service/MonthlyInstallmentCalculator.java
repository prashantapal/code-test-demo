package com.moneybin.mortage.mortagetest1.service;

import java.util.Optional;

public interface MonthlyInstallmentCalculator {
    Optional<String> calculate(String eachLine);
}
