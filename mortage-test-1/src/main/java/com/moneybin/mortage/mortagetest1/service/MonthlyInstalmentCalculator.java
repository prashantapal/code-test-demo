package com.moneybin.mortage.mortagetest1.service;

import java.util.Optional;

public interface MonthlyInstalmentCalculator {
    Optional<String> calculate(String eachLine);
}
