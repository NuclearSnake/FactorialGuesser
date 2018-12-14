package com.neoproduction.factorialguesser;

/**
 * Created by NuclearSnake 14.12.18 at 22:07
 *
 * 'Brute force' solution: multiplying 1 by 1, 2, 3, etc. try to get enough to fit the provided factorial
 */
public class FactorialGuesserBruteForce implements FactorialGuesser {
    @Override
    public int getNFromFactorial(long factorialOfN) {
        if(factorialOfN == 1)
            return 1;

        long factorial = 1;
        int n = 1;
        while(factorial < factorialOfN){
            factorial *= n++;
            if(factorial == factorialOfN)
                return n-1;
        }

        return BAD_FACTORIAL;
    }
}
