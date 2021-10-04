package com.moneybin.mortage.mortagetest2.utils;

public final class MathUtil {

    private MathUtil() {
        //Should not instantiate util class
    }

    public static double power(double base, int power) {
        if (base <= 0.0) {
            throw new IllegalArgumentException("Base number should be positive to get the power: " + base);
        }
        double result = 1.0;
        final int absPower = absolute(power);
        for (int i = 1; i <= absPower; i++) {
            result *= base;
        }
        return power > 0 ? result : 1.0 / result;
    }

    private static int absolute(int value) {
        return value > 0 ? value : -1 * value;
    }
}
