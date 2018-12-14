package com.neoproduction.factorialguesser;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FactorialProblemTest {
    @Test
    public void tryToParseInput_Text() {
        assertEquals(null, new FactorialProblem(null, null).tryToParseInput("text"));
    }

    @Test
    public void tryToParseInput_Negative() {
        assertTrue(BigInteger.valueOf(-1).compareTo(new FactorialProblem(null, null).tryToParseInput("-1")) == 0);
    }

    @Test
    public void tryToParseInput_Positive() {
        assertTrue(BigInteger.valueOf(42).compareTo(new FactorialProblem(null, null).tryToParseInput("42")) == 0);
    }

    @Test
    public void isValidNumber_Negative() {
        assertFalse(new FactorialProblem(null, null).isValidNumber(BigInteger.valueOf(-1)));
    }

    @Test
    public void isValidNumber_Zero() {
        assertFalse(new FactorialProblem(null, null).isValidNumber(BigInteger.valueOf(0)));
    }

    @Test
    public void isValidNumber_Positive() {
        assertTrue(new FactorialProblem(null, null).isValidNumber(BigInteger.valueOf(1)));
    }

    @Test
    public void loop_ValidDataGivesSameResultAsMatchesProblem() {
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(BigInteger.valueOf(7)));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(BigInteger.valueOf(1)));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(BigInteger.valueOf(2)));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(BigInteger.valueOf(5040)));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(BigInteger.valueOf(479001600L)));
    }

    @Test
    public void loop_InvalidDataFails() {
        assertEquals(FactorialProblem.ERROR, getMatchesProblemLoopResult("-1"));
    }

    private boolean doesFactorialProblemResultEqualsFactorialGuesserResult(BigInteger factorialOfN){
        int matchesProblemResult = getMatchesProblemLoopResult(factorialOfN.toString());
        int matchesCounterResult = new FactorialGuesserBruteForce().getNFromFactorial(factorialOfN);

        return matchesProblemResult == matchesCounterResult;
    }

    private int getMatchesProblemLoopResult(String input){
        return new FactorialProblem(new InputManager() {
            @Override
            String getInputRealization() {
                return input;
            }
        }, new FactorialGuesserBruteForce()).loop();
    }
}