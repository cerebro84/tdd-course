package com.rockman.tdd.calculator;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

    @Test
    public void testsWork() {
        assertThat("Tests work", true, is(true));
    }

    @Test
    public void testReturnZeroIfPassedEmptyString() {
        assertThat("Sum returns 0 for empty string", StringCalculator.add(""), is(0));
    }

    @Test
    public void testAddSingleNumber3ShouldReturnTheNumberItself() {
        assertEquals(0, StringCalculator.add("3"));
    }

    @Test
    public void testAddSingleNumber42ShouldReturnTheNumberItself() {
        assertEquals(0, StringCalculator.add("42"));
    }

    @Test
    public void testAddTwoNumbersShouldReturnTheirSum() {
        assertEquals(42, StringCalculator.add("31,11"));
    }

    @Test
    public void testAddTwoNumbers1And2ShouldReturnTheirSum() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    @Ignore
    public void testAddTwoNumbers1And2ShouldReturnTheirSumVeryBig() {
        assertEquals(3, StringCalculator.add("19999999999999999999,999999999999999999999999999999992"));
    }

    @Test
    public void testAdd5Numbers() {
        assertEquals(42, StringCalculator.add("20,18,4"));
    }

    @Test
    @Ignore
    public void testAddUnknownLengthOfRandomNumbers() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int length = random.nextInt(40) + 2;
        for (int i = 0; i < length; i++) {
            Integer tmp = random.nextInt(42);
        }

    }

}
