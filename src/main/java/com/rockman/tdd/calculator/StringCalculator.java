package com.rockman.tdd.calculator;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }
        final String[] numbersArrays = numbers.split(",");
        if (numbersArrays.length == 1) {
            return 0;
        }

        final Integer sum = Arrays.stream(numbersArrays)
                .map((String num) -> Integer.parseInt((num)))
                .reduce((num1, num2) -> num1 + num2).get();

        return sum;
    }
}
