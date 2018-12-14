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
        long start = System.nanoTime();
//        factorialGuesser.getNFromFactorial(5040);
        factorialGuesser.getNFromFactorial(479001600L);
        long end = System.nanoTime();
        long time1 = end-start;
        start = System.nanoTime();
        factorialGuesser.getNFromFactorial(479001600L);
        end = System.nanoTime();
        long time2 = end-start;
        System.out.println(String.format("Time 1 = %dns, time 2 = %dns, 2 time was faster by %dns", time1, time2, (time1-time2)));
        assertTrue(time2 < time1);
    }
}