package com.neoproduction.factorialguesser;

/**
 * Created by NuclearSnake 14.12.18 at 22:20
 *
 * 'Reverse' simple solution: dividing provided factorial by 1, 2, 3, etc., the correct n is when we get 1
 */
public class FactorialGuesserSimpleReverse implements FactorialGuesser {
    @Override
    public int getNFromFactorial(long factorialOfN) {
        if(factorialOfN == 1)
            return 1;

        int n = 1;
        while(factorialOfN > 0){
            if(factorialOfN % n == 0)
                factorialOfN /= n++;
            else
                return BAD_FACTORIAL;
            if(factorialOfN == 1)
                return n-1;
        }

        return BAD_FACTORIAL;
    }
}
