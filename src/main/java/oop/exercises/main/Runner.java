/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */
package oop.exercises.main;

import oop.exercises.util.DataReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.IntPredicate;


public class Runner {

    private static final DataReader in = new DataReader();
    private static final int MIN_EXERCISE = 41;
    private static final int MAX_EXERCISE = 46;
    private static final IntPredicate VALIDATE_EXERCISE =
            x -> MIN_EXERCISE <= x && x <= MAX_EXERCISE;

    public static void main(String[] args) {
        Runner runner = new Runner();
        do {
            int exerciseNumber = runner.readExercise();
            runner.runExercise(exerciseNumber);
        } while(runner.runAgain());
    }

    private int readExercise() {
        return in.readIntValidatedWithCondition(
                buildPrompt(),
                "That is not a valid exercise number, please try again",
                VALIDATE_EXERCISE);
    }

    private void runExercise(int exerciseNumber) {
        try {
            Method main = buildMainMethod(exerciseNumber);
            runMainMethod(main, exerciseNumber);
        } catch (ClassNotFoundException | NoSuchMethodException |
                 IllegalAccessException | InvocationTargetException e) {
            System.out.printf("Could not run exercise%n%s", e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean runAgain() {
        String response = in.readString("Run again? (Y/N): ");
        return response.matches("[Yy]([Ee][Ss])?");
    }

    private Method buildMainMethod(int exerciseNumber) throws ClassNotFoundException, NoSuchMethodException {
        String exercisePath = buildExercisePath(exerciseNumber);
        Class<?> exercise = getExerciseClass(exercisePath);
        return exercise.getDeclaredMethod("main", String[].class);
    }

    private void runMainMethod(Method main, int exerciseNumber) throws InvocationTargetException, IllegalAccessException {
        System.out.printf("Running exercise %d...%n%n", exerciseNumber);
        main.invoke(null, (Object[]) new String[1]);
    }

    private Class<?> getExerciseClass(String path) throws ClassNotFoundException {
            return Class.forName(path);
    }

    private String buildExercisePath(int exerciseNumber) {
        return String.format("oop.exercises.ex%d.Application", exerciseNumber);
    }

    private String buildPrompt() {
        return String.format("Enter an exercise number (%d-%d, inclusive): ",
                MIN_EXERCISE, MAX_EXERCISE);
    }
}
