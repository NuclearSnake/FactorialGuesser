package com.neoproduction.factorialguesser;

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
    private HashMap<Long, Integer> previousResults = new HashMap<>();

    @Override
    public int getNFromFactorial(long factorialOfN) {
        if(factorialOfN == 1)
            return 1;

        long factorial = 1;
        int n = 1;

        // if n > 6
        if(factorialOfN > 720){
            factorial = tryToGetRightFactorial(factorialOfN);
            if(factorial != -1) {
                n = previousResults.get(factorial);
                if (factorial == factorialOfN)
                    return n;
            } else {
                factorial = 1;
            }
        }

        while(factorial < factorialOfN){
            factorial *= n;
            previousResults.put(factorial, n);
            if(factorial == factorialOfN)
                return n;
            n++;
        }

        return BAD_FACTORIAL;
    }

    private long tryToGetRightFactorial(long factorialOfN){
        if(previousResults.containsKey(factorialOfN))
            return factorialOfN;

        long maxSavedFactorialLessOrEqualToRequired = -1;
        for(Long key : previousResults.keySet()){
            if(key < factorialOfN && key > maxSavedFactorialLessOrEqualToRequired) {
                maxSavedFactorialLessOrEqualToRequired = key;
            }
        }

        return maxSavedFactorialLessOrEqualToRequired;
    }
}
