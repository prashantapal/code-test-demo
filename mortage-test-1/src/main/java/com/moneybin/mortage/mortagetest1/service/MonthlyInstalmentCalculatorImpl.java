package com.moneybin.mortage.mortagetest1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.moneybin.mortage.mortagetest1.utils.MathUtil.power;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class MonthlyInstalmentCalculatorImpl implements MonthlyInstalmentCalculator {

    private static final String COMMA_DELIMITER = ",";
    private static final String DOUBLE_QUOTE = "\"";
    private static Logger logger = LoggerFactory.getLogger(MonthlyInstalmentCalculatorImpl.class);

    @Override
    public Optional<String> calculate(String eachLine) {
        return Optional.ofNullable(eachLine)
                .filter(this::isValidContent)
                .map(this::calculateInstalment);

    }

    private boolean isValidContent(String line) {
        //TODO Prashanta Kumar Pal 04.10.2021, Better to use regex to validate input, may be not so important at this point.
        if (isNotBlank(line) && line.split(COMMA_DELIMITER).length >= 4) {
            return true;
        }
        logger.warn("Invalid file content: " + line + ", skipping the line.........");
        return false;
    }

    /**
     * Mathematics equation simplification
     * E = U[b(1 + b)^p]/[(1 + b)^p - 1]
     *   = Ub/[{(1 + b)^p - 1}{(1 + b)^-p}]
     *   = Ub/[1 - (1 + b)^-p]
     */
    private String calculateInstalment(String line) {
        final List<String> prospect = parseLine(line);
        try {

            final double loanAmount = Double.valueOf(prospect.get(1));
            final double monthlyInterest = Double.valueOf(prospect.get(2)) / 100 / 12;
            final int months = Integer.valueOf(prospect.get(3)) * 12;
            final double emi = (loanAmount * monthlyInterest) / (1 - power(1 + monthlyInterest, -months));
            return prospect.get(0) + " wants to borrow " + loanAmount + " € for a period of " + prospect.get(3) + " years and pay " + emi + " € each month";
        } catch (Exception ex) {
            logger.error("Error occurred while calculating monthly instalment: " + line, ex);
            return null;
        }
    }

    private List<String> parseLine(String line) {
        List<String> contents = new ArrayList<>();
        if (line.startsWith(DOUBLE_QUOTE)) {
            contents.add(line.substring(0, line.lastIndexOf(DOUBLE_QUOTE) + 1));
            line = line.substring(line.lastIndexOf(DOUBLE_QUOTE) + 2);
            contents.addAll(asList(line.split(COMMA_DELIMITER)));
            return contents;
        }
        return asList(line.split(COMMA_DELIMITER));
    }
}
