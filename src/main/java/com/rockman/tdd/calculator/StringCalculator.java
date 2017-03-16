package com.rockman.tdd.calculator;

import org.springframework.util.StringUtils;

public class StringCalculator {
    public static int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }
        final String[] numbersArrays = numbers.split(",");
        if (numbersArrays.length == 1) {
            return 0;
        }
        return Integer.valueOf(numbersArrays[0]) + Integer.valueOf(numbersArrays[1]);
    }
}
