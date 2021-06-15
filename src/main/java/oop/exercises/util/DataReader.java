/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */
package oop.exercises.util;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class DataReader {

    private final Scanner in = new Scanner(System.in);

    public DataReader() { }

    /**
     * Prompts the user for an input, and returns the line they typed
     * into the console as a {@code String}
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @return {@code String} value that the user typed to the console
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }

    /**
     * Prompts the user for an input, and returns the line they typed
     * into the console as a {@code int}
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @return {@code int} value that the user typed to the console
     */
    public int readInt(String prompt) {
        System.out.print(prompt);
        return in.nextInt();
    }

    /**
     * Prompts the user for an input, and returns the line they typed
     * into the console as a {@code int}
     * <p> If the user does not enter an {@code int}, the errorMessage is
     * printed to the console, and the user is prompted for input again.
     * The user will be continuously shown the errorMessage and prompt until
     * they enter a valid value
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @param errorMessage {@code String} to be displayed when the user
     *                                   enters an erroneous value
     * @return {@code int} value that the user typed to the console
     */
    public int readIntValidated(String prompt, String errorMessage) {
        boolean continueLoop = true;
        int output = 0;

        while(continueLoop) {
            try {
                System.out.print(prompt);
                String input = in.nextLine();
                output = Integer.parseInt(input);
                continueLoop = false;
            } catch (NumberFormatException e) {
                if(!errorMessage.isEmpty()) {
                    System.out.println(errorMessage);
                }
            }
        }
        return output;
    }

    /**
     * {@code errorMessage} defaults to the empty {@code String}
     *
     * @see #readIntValidated(String, String)
     */
    public int readIntValidated(String prompt) {
        return readIntValidated(prompt, "");
    }

    /**
     * Prompts the user for an input, and returns the line they typed
     * into the console as a {@code double}
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @return {@code double} value that the user typed to the console
     */
    public double readDouble(String prompt) {
        System.out.print(prompt);
        return in.nextDouble();
    }

    /**
     * Prompts the user for an input, and returns the line they typed
     * into the console as a {@code double}
     * <p> If the user does not enter an {@code double}, the errorMessage is
     * printed to the console, and the user is prompted for input again.
     * The user will be continuously shown the errorMessage and prompt until
     * they enter a valid value
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @param errorMessage {@code String} to be displayed when the user
     *                                   enters an erroneous value
     * @return {@code double} value that the user typed to the console
     */
    public double readDoubleValidated(String prompt, String errorMessage) {
        boolean continueLoop = true;
        double output = 0;

        while(continueLoop) {
            try {
                System.out.print(prompt);
                String input = in.nextLine();
                output = Double.parseDouble(input);
                continueLoop = false;
            } catch (NumberFormatException e) {
                if(!errorMessage.isEmpty()) {
                    System.out.println(errorMessage);
                }
            }
        }
        return output;
    }

    /**
     * {@code errorMessage} defaults to the empty {@code String}
     *
     * @see #readDoubleValidated(String, String)
     */
    public double readDoubleValidated(String prompt) {
        return readDoubleValidated(prompt, "");
    }

    /**
     * Prompts the user for an input n times, and returns the inputs they typed
     * into the console as a {@code Array} of {@code double}s
     *
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @param n Number of {@code double}s the user must input
     * @return An array of doubles
     * @see #readDouble(String)
     */
    public double[] readNDoubles(String prompt, int n) {
        double[] output = new double[n];
        for(int i = 0; i < n; i++) {
            output[i] = readDouble(prompt);
        }
        return output;
    }

    /**
     * Prompts the user for an input n times, and returns the inputs they typed
     * into the console as a {@code Array} of {@code double}s
     * <p> If the user does not enter an {@code double}, the errorMessage is
     * printed to the console, and the user is prompted for input again.
     * The user will be continuously shown the errorMessage and prompt until
     * they enter a valid value
     *
     * @param prompt {@code String} to be displayed as a prompt for the user
     * @param n Number of {@code double}s the user must input
     * @return An array of doubles
     * @see #readDoubleValidated(String, String)
     */
    public double[] readNDoublesValidated(String prompt, String errorMessage, int n) {
        double[] output = new double[n];
        for(int i = 0; i < n; i++) {
            output[i] = readDoubleValidated(prompt, errorMessage);
        }
        return output;
    }

    /**
     * {@code errorMessage} defaults to the empty {@code String}
     *
     * @see #readNDoublesValidated(String, String, int)
     */
    public double[] readNDoublesValidated(String prompt, int n) {
        return readNDoublesValidated(prompt, "", n);
    }


    public int readIntValidatedWithCondition(String prompt, String errorMessage, IntPredicate condition) {
        boolean continueLoop = true;
        int output = 0;

        while(continueLoop) {
            try {
                output = readIntValidated(prompt, errorMessage);
                if(!IntStream.of(output).anyMatch(condition)) {
                    throw new IllegalArgumentException("Input did not meet the condition");
                }
                continueLoop = false;
            } catch (IllegalArgumentException e) {
                if(!errorMessage.isEmpty()) {
                    System.out.println(errorMessage);
                }
            }
        }
        return output;
    }
}
