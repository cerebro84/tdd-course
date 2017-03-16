package com.rockman.tdd.calculator;

import com.sun.media.sound.InvalidFormatException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

    @Test
    public void testsWork() {
        assertThat("Tests work", true, is(true));
    }

    @Test
    public void testReturnZeroIfPassedEmptyString() throws Exception {
        assertThat("Sum returns 0 for empty string", StringCalculator.add(""), is(0));
    }

    @Test
    public void testAddSingleNumber3ShouldReturnTheNumberItself() throws Exception {
        assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public void testAddSingleNumber42ShouldReturnTheNumberItself() throws Exception {
        assertEquals(42, StringCalculator.add("42"));
    }

    @Test
    public void testAddTwoNumbersShouldReturnTheirSum() throws Exception {
        assertEquals(42, StringCalculator.add("31,11"));
    }

    @Test
    public void testAddTwoNumbers1And2ShouldReturnTheirSum() throws Exception {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    @Ignore
    public void testAddTwoNumbers1And2ShouldReturnTheirSumVeryBig() throws Exception {
        assertEquals(3, StringCalculator.add("19999999999999999999,999999999999999999999999999999992"));
    }

    @Test
    public void testAdd5Numbers() throws InvalidFormatException {
        assertEquals(42, StringCalculator.add("20,18,4"));
    }

    @Test
    public void test3numbersWithNewLinesAndComma() throws InvalidFormatException {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test(expected = NumberFormatException.class)
    public void test3numbersWithNewLinesAndCommaThrowsException()  {
        StringCalculator.add("1,\n");
    }

    @Test
    public void testCustomDelimiter(){
        assertEquals(3, StringCalculator.add("//;\n1;2") );
    }

    @Test(expected = NegativesNotAllowed.class)
    public void testNegativeNumbersNotAllowed() {
        StringCalculator.add("//@\n-1@-3");
    }

    @Test
    public void testNegativeNumbersNotAllowedStoredInException() {
        try {
            StringCalculator.add("//@\n-1@-3");
            fail("Expected exception");
        } catch (NegativesNotAllowed negativesNotAllowed) {
            assertEquals(Arrays.asList(new Integer[]{-1, -3}), negativesNotAllowed.getNumbers());
        }
    }

    @Test
    public void testThatNumbersGreatherThan1000AreIgnored() {
        assertEquals(1042, StringCalculator.add("//ù\n1000ù1001ù4002ù42"));
    }

}
