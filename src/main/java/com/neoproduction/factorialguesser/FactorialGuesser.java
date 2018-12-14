package com.neoproduction.factorialguesser;

import java.math.BigInteger;

/**
 * Created by NuclearSnake 14.12.18 at 22:21
 *
 * Gets the n by the n! (n factorial) value
 */
public interface FactorialGuesser {
    int BAD_FACTORIAL = Integer.MIN_VALUE+1;

    int getNFromFactorial(BigInteger factorialOfN);
}
