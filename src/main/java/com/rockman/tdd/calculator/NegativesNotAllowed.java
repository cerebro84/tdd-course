package com.rockman.tdd.calculator;

import java.util.Collection;

public class NegativesNotAllowed extends RuntimeException {
    private final Collection<Integer> numbers;
    public NegativesNotAllowed(Collection<Integer> numbers) {
        super();
        this.numbers = numbers;
    }

    public Collection<Integer> getNumbers() {
        return numbers;
    }
}
