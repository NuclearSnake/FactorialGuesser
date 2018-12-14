package com.neoproduction.factorialguesser;

import java.math.BigInteger;

/**
 * Created by NuclearSnake 14.12.18 at 22:07
 *
 * 'Brute force' solution: multiplying 1 by 1, 2, 3, etc. try to get enough to fit the provided factorial
 */
public class FactorialGuesserBruteForce implements FactorialGuesser {
    @Override
    public int getNFromFactorial(BigInteger factorialOfN) {
        if(factorialOfN.compareTo(BigInteger.ONE) == 0)
            return 1;

        BigInteger factorial = BigInteger.ONE;
        int n = 1;
        while(factorial.compareTo(factorialOfN) < 0){
            factorial = factorial.multiply(BigInteger.valueOf(n++));

            if(factorial.compareTo(factorialOfN) == 0)
                return n-1;
        }

        return BAD_FACTORIAL;
    }
}
