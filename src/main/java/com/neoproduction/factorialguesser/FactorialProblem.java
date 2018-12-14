package com.neoproduction.factorialguesser;

/**
 * Created by NuclearSnake 14.12.18 at 22:03
 *
 * A class suited for a specific factorial problem input-output management
 * @see InputManager
 * @see FactorialGuesser
 */
public class FactorialProblem {
    static int ERROR = Integer.MIN_VALUE;

    private InputManager inputManager;
    private FactorialGuesser factorialGuesser;

    private int factorialOfN = ERROR;

    public FactorialProblem(InputManager inputManager, FactorialGuesser factorialGuesser) {
        this.inputManager = inputManager;
        this.factorialGuesser = factorialGuesser;
    }

    /**
     * @return factorial of N parsed from the latest user input
     */
    public int getFactorialOfN() {
        return factorialOfN;
    }

    /**
     * main loop of the class, where it gets user input, processes it tries to get the result
     * @return the result of calculation or {@link FactorialProblem#ERROR}
     */
    public int loop(){
        String input;
        factorialOfN = ERROR;

        input = inputManager.getInput("Factorial of N: ");
        if("q".equals(input)) {
            System.out.println("\n\nBye!");
            System.exit(0);
        }

        factorialOfN = tryToParseInput(input);
        if(factorialOfN == ERROR)
            return ERROR;

        if(!isValidNumber(factorialOfN)) {
            System.out.println("Invalid input :(");
            return ERROR;
        }

        return factorialGuesser.getNFromFactorial(factorialOfN);
    }

    /**
     * Parses integer from the input string
     * @param input from user
     * @return integer or {@link FactorialProblem#ERROR}
     */
    protected int tryToParseInput(String input){
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException nfe){
            System.out.println("Error! Input is not a number.");
            return ERROR;
        }
    }

    /**
     * Checks if the integer input is valid for the current task
     * @param input from user
     * @return true if the input is valid, false otherwise
     */
    protected boolean isValidNumber(int input){
        return input > 0;
    }
}
