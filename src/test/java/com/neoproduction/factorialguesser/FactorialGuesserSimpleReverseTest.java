package com.neoproduction.factorialguesser;

import org.junit.Test;

import static com.neoproduction.factorialguesser.FactorialGuesser.BAD_FACTORIAL;
import static org.junit.Assert.*;

public class FactorialGuesserSimpleReverseTest {

    @Test
    public void getNFromFactorial_Negative() {
        FactorialGuesser factorialGuesser = new FactorialGuesserSimpleReverse();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(-1));
    }

    @Test
    public void getNFromFactorial_NoSuchFactorial() {
        FactorialGuesser factorialGuesser = new FactorialGuesserSimpleReverse();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(7));
    }

    @Test
    public void getNFromFactorial_1() {
        FactorialGuesser factorialGuesser = new FactorialGuesserSimpleReverse();
        int result = factorialGuesser.getNFromFactorial(1);
        assertTrue(result == 1 || result == 0);
    }

    @Test
    public void getNFromFactorial_Small() {
        FactorialGuesser factorialGuesser = new FactorialGuesserSimpleReverse();
        assertEquals(2, factorialGuesser.getNFromFactorial(2));
    }

    @Test
    public void getNFromFactorial_Medium() {
        FactorialGuesser factorialGuesser = new FactorialGuesserSimpleReverse();
        assertEquals(7, factorialGuesser.getNFromFactorial(5040));
    }

    @Test
    public void getNFromFactorial_Big() {
        FactorialGuesser factorialGuesser = new FactorialGuesserSimpleReverse();
        assertEquals(12, factorialGuesser.getNFromFactorial(479001600L));
    }
}