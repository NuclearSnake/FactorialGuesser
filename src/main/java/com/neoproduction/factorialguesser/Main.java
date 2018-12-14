package com.neoproduction.factorialguesser;

/**
 * Created by NuclearSnake 14.12.18 at 21:57
 *
 * The main class, starts and manages the application. Using {@link FactorialProblem}, initializing it with
 * instances of {@link InputManager} and {@link FactorialGuesser}, gets the result of solving the simple math
 * problem and prints it to the user
 *
 * @see FactorialProblem
 * @see InputManager
 * @see FactorialGuesser
 */
public class Main {
    public static void main(String[] args){
        System.out.println("This is a factorial guesser app. You enter the factorial of N, the program " +
                "responds with a guessed n number.\n" +
                "[factorial is always greater than 0 and the 1! = 0! = 1]\n" +
                "Print 'q' to quit\n");
        FactorialProblem factorialProblem = new FactorialProblem(new InputManagerImpl(), new FactorialGuesserBruteForce());
        do{
            int result = factorialProblem.loop();
            if(result == FactorialProblem.ERROR)
                continue;

            if(result == FactorialGuesser.BAD_FACTORIAL){
                System.out.println(String.format("There is no such n that n! = %d. Try another factorial", factorialProblem.getFactorialOfN()));
                continue;
            }

            if(result != 1 && result != 0)
                System.out.println(String.format("%d = %d!", factorialProblem.getFactorialOfN(), result));
            else
                System.out.println(String.format("%d = 0! = 1!", factorialProblem.getFactorialOfN()));
        } while (true);
    }
}
