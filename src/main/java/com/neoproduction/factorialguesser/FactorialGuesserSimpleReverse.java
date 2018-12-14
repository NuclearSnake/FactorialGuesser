package com.neoproduction.factorialguesser;

import java.math.BigInteger;

/**
 * Created by NuclearSnake 14.12.18 at 22:20
 *
 * 'Reverse' simple solution: dividing provided factorial by 1, 2, 3, etc., the correct n is when we get 1
 */
public class FactorialGuesserSimpleReverse implements FactorialGuesser {
    @Override
    public int getNFromFactorial(BigInteger factorialOfN) {
        if(factorialOfN.compareTo(BigInteger.ONE) == 0)
            return 1;

        int n = 1;
        while(factorialOfN.compareTo(BigInteger.ZERO) > 0){
            // factorial % n == 0
            if(factorialOfN.mod(BigInteger.valueOf(n)).compareTo(BigInteger.ZERO) == 0)
                // factorial /= n++
                factorialOfN = factorialOfN.divide(BigInteger.valueOf(n++));
            else
                return BAD_FACTORIAL;
            if(factorialOfN.compareTo(BigInteger.ONE) == 0)
                return n-1;
        }

        return BAD_FACTORIAL;
    }
}
