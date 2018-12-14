package com.neoproduction.factorialguesser;

import org.junit.Test;

import java.math.BigInteger;

import static com.neoproduction.factorialguesser.FactorialGuesser.BAD_FACTORIAL;
import static org.junit.Assert.*;

public class FactorialGuesserBruteForceTest {

    @Test
    public void getNFromFactorial_Negative() {
        FactorialGuesser factorialGuesser = new FactorialGuesserBruteForce();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(BigInteger.valueOf(-1)));
    }

    @Test
    public void getNFromFactorial_NoSuchFactorial() {
        FactorialGuesser factorialGuesser = new FactorialGuesserBruteForce();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(BigInteger.valueOf(7)));
    }

    @Test
    public void getNFromFactorial_1() {
        FactorialGuesser factorialGuesser = new FactorialGuesserBruteForce();
        int result = factorialGuesser.getNFromFactorial(BigInteger.valueOf(1));
        assertTrue(result == 1 || result == 0);
    }

    @Test
    public void getNFromFactorial_Small() {
        FactorialGuesser factorialGuesser = new FactorialGuesserBruteForce();
        assertEquals(2, factorialGuesser.getNFromFactorial(BigInteger.valueOf(2)));
    }

    @Test
    public void getNFromFactorial_Medium() {
        FactorialGuesser factorialGuesser = new FactorialGuesserBruteForce();
        assertEquals(7, factorialGuesser.getNFromFactorial(BigInteger.valueOf(5040)));
    }

    @Test
    public void getNFromFactorial_Big() {
        FactorialGuesser factorialGuesser = new FactorialGuesserBruteForce();
        assertEquals(12, factorialGuesser.getNFromFactorial(BigInteger.valueOf(479001600L)));
    }
}