package com.neoproduction.factorialguesser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FactorialProblemTest {
    @Test
    public void tryToParseInput_Text() {
        assertEquals(FactorialProblem.ERROR, new FactorialProblem(null, null).tryToParseInput("text"));
    }

    @Test
    public void tryToParseInput_Negative() {
        assertEquals(-1, new FactorialProblem(null, null).tryToParseInput("-1"));
    }

    @Test
    public void tryToParseInput_Positive() {
        assertEquals(42, new FactorialProblem(null, null).tryToParseInput("42"));
    }


    @Test
    public void isValidNumber_Negative() {
        assertFalse(new FactorialProblem(null, null).isValidNumber(-1));
    }
    @Test
    public void isValidNumber_Zero() {
        assertFalse(new FactorialProblem(null, null).isValidNumber(0));
    }
    @Test
    public void isValidNumber_Positive() {
        assertTrue(new FactorialProblem(null, null).isValidNumber(1));
    }

    @Test
    public void loop_ValidDataGivesSameResultAsMatchesProblem() {
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(7));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(1));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(2));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(5040));
        assertTrue(doesFactorialProblemResultEqualsFactorialGuesserResult(479001600L));
    }

    @Test
    public void loop_InvalidDataFails() {
        assertEquals(FactorialProblem.ERROR, getMatchesProblemLoopResult("-1"));
    }

    private boolean doesFactorialProblemResultEqualsFactorialGuesserResult(long factorialOfN){
        int matchesProblemResult = getMatchesProblemLoopResult(Long.toString(factorialOfN));
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