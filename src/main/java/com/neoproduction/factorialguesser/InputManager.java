package com.neoproduction.factorialguesser;

/**
 * Created by NuclearSnake 14.12.18 at 20:09
 *
 * Gets user input in a unified form prepending with a prompt text.
 * Created in order to be able to communicate with different sources
 */
public abstract class InputManager {
    abstract String getInputRealization();
    void print(String prompt){}

    final public String getInput(String prompt){
        print(prompt);
        return getInputRealization();
    }
}
