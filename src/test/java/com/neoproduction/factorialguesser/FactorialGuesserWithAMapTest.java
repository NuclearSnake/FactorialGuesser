package com.neoproduction.factorialguesser;

import org.junit.Test;

import static com.neoproduction.factorialguesser.FactorialGuesser.BAD_FACTORIAL;
import static org.junit.Assert.*;

public class FactorialGuesserWithAMapTest {
    @Test
    public void getNFromFactorial_Negative() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(-1));
    }

    @Test
    public void getNFromFactorial_NoSuchFactorial() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(7));
    }

    @Test
    public void getNFromFactorial_1() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        int result = factorialGuesser.getNFromFactorial(1);
        assertTrue(result == 1 || result == 0);
    }

    @Test
    public void getNFromFactorial_Small() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(2, factorialGuesser.getNFromFactorial(2));
    }

    @Test
    public void getNFromFactorial_Medium() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(7, factorialGuesser.getNFromFactorial(5040));
    }

    @Test
    public void getNFromFactorial_Big() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(12, factorialGuesser.getNFromFactorial(479001600L));
    }

    @Test
    public void getNFromFactorial_testMapEfficiency() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        long start = System.currentTimeMillis();
        factorialGuesser.getNFromFactorial(5040);
        long end = System.currentTimeMillis();
        long diff1 = start-end;
        start = System.currentTimeMillis();
        factorialGuesser.getNFromFactorial(479001600L);
        end = System.currentTimeMillis();
        long diff2 = start-end;
        System.out.println(String.format("Time 1 = %dms, time 2 = %dms, 2 time was faster by %dms", diff1, diff2, (diff1-diff2)));
    }
}