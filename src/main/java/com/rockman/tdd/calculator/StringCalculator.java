package com.rockman.tdd.calculator;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final int MAX_ADDENDUM = 1000;

    public static int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }

        NumbersAndDelimiter numbersAndDelimiter = getDelimiters(numbers);
        final String[] numbersArrays = numbersAndDelimiter.getNumbersToSum().split(numbersAndDelimiter.getDelimiters(),-1);

        int acc = 0;
        List<Integer> negatives = new ArrayList<Integer>();
        for (String numberString : numbersArrays) {
            Integer currentNumber = Integer.valueOf(numberString);
            if (currentNumber < 0) {
                negatives.add(currentNumber);
            } else {
                if (currentNumber <= MAX_ADDENDUM) {
                    acc += currentNumber;
                }
            }
        }
        if (!negatives.isEmpty()) {
            throw new NegativesNotAllowed(negatives);
        }
        return acc ;
    }

    private static NumbersAndDelimiter getDelimiters(String numbers) {
        StringBuilder delimiters = new StringBuilder(",|\n");
        if (numbers.startsWith("//")) {
            String newDelimiter = numbers.substring(2,3);
            delimiters.append("|").append(newDelimiter);
            numbers = numbers.substring(4);
        }
        return NumbersAndDelimiter.builder()
                .delimiters(delimiters.toString())
                .numbersToSum(numbers)
                .build();
    }

    private static List<Integer> splitAndConvert(String numbers, String delimiter) {
        List<Integer> tmp = Arrays.stream(numbers.split(delimiter, -1)).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        return tmp;
    }

    private void isListPositive(List<Integer> numbers) throws NegativesNotAllowed {
        List<Integer> negatives = numbers.stream().filter(integer -> integer < 0).collect(Collectors.toList());
        if (negatives.size() > 0) {
            throw new NegativesNotAllowed(negatives);
        }
    }

    @Data
    @Builder
    static class NumbersAndDelimiter {
        private String delimiters;
        private String numbersToSum;

    }

}
