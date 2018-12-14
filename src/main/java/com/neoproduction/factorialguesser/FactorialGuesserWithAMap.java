package com.neoproduction.factorialguesser;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by NuclearSnake 14.12.18 at 22:58
 *
 * Smarty version of the 'Brute force' solution (multiplying 1 by 1, 2, 3, etc. try to get enough to fit
 * the provided factorial). It saves all the calculated factorials in a map with the key of a factorial and a value
 * of the appropriate n such that n! = key of that value n.
 *
 */
public class FactorialGuesserWithAMap implements FactorialGuesser {
    private HashMap<BigInteger, Integer> previousResults = new HashMap<>();

    @Override
    public int getNFromFactorial(BigInteger factorialOfN) {
        if(factorialOfN.compareTo(BigInteger.ONE) == 0)
            return 1;

        BigInteger factorial = null;
        int n = 1;

        // if n > 6
        if(factorialOfN.compareTo(BigInteger.valueOf(720)) > 0){
            factorial = tryToGetRightFactorial(factorialOfN);
            if(factorial != null) {
                n = previousResults.get(factorial);
                if (factorial == factorialOfN)
                    return n;
            }
        }

        factorial = BigInteger.ONE;

        while(factorial.compareTo(factorialOfN) < 0){
            factorial = factorial.multiply(BigInteger.valueOf(n));
            previousResults.put(factorial, n);
            if(factorial.compareTo(factorialOfN) == 0)
                return n;
            n++;
        }

        return BAD_FACTORIAL;
    }

    private BigInteger tryToGetRightFactorial(BigInteger factorialOfN){
        if(previousResults.containsKey(factorialOfN))
            return factorialOfN;

        BigInteger maxSavedFactorialLessOrEqualToRequired = null;
        for(BigInteger key : previousResults.keySet()){
            if(key.compareTo(factorialOfN) < 0 && (maxSavedFactorialLessOrEqualToRequired == null || key.compareTo(maxSavedFactorialLessOrEqualToRequired) > 0)) {
                maxSavedFactorialLessOrEqualToRequired = key;
            }
        }

        return maxSavedFactorialLessOrEqualToRequired;
    }
}
