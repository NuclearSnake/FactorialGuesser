package com.neoproduction.factorialguesser;

import org.junit.Test;

import java.math.BigInteger;

import static com.neoproduction.factorialguesser.FactorialGuesser.BAD_FACTORIAL;
import static org.junit.Assert.*;

public class FactorialGuesserWithAMapTest {
    @Test
    public void getNFromFactorial_Negative() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(BigInteger.valueOf(-1)));
    }

    @Test
    public void getNFromFactorial_NoSuchFactorial() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(BAD_FACTORIAL, factorialGuesser.getNFromFactorial(BigInteger.valueOf(7)));
    }

    @Test
    public void getNFromFactorial_1() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        int result = factorialGuesser.getNFromFactorial(BigInteger.valueOf(1));
        assertTrue(result == 1 || result == 0);
    }

    @Test
    public void getNFromFactorial_Small() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(2, factorialGuesser.getNFromFactorial(BigInteger.valueOf(2)));
    }

    @Test
    public void getNFromFactorial_Medium() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(7, factorialGuesser.getNFromFactorial(BigInteger.valueOf(5040)));
    }

    @Test
    public void getNFromFactorial_Big() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        assertEquals(12, factorialGuesser.getNFromFactorial(BigInteger.valueOf(479001600L)));
    }

    @Test
    public void getNFromFactorial_testMapEfficiency() {
        FactorialGuesser factorialGuesser = new FactorialGuesserWithAMap();
        long start = System.nanoTime();
//        factorialGuesser.getNFromFactorial(5040);
        BigInteger bigInteger = BigInteger.ONE;
        for(int i = 1; i < 50000; i++){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        factorialGuesser.getNFromFactorial(bigInteger);
        long end = System.nanoTime();
        long time1 = end-start;
        start = System.nanoTime();
        factorialGuesser.getNFromFactorial(bigInteger);
        end = System.nanoTime();
        long time2 = end-start;
        System.out.println(String.format("Time 1 = %dns, time 2 = %dns, 2 time was faster by %dns", time1, time2, (time1-time2)));
        assertTrue(time2 < time1);
    }
}