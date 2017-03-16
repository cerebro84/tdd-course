package com.rockman.tdd.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

}
