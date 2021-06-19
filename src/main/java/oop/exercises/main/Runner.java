/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.main;

import oop.exercises.util.ConsoleDataReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.IntPredicate;

public class Runner {

    private static final int MIN_EXERCISE = 41;
    private static final int MAX_EXERCISE = 46;
    private static final ConsoleDataReader in = new ConsoleDataReader();
    private static final IntPredicate VALIDATE_EXERCISE =
            x -> (MIN_EXERCISE <= x && x <= MAX_EXERCISE) || x == -1;

    public static void main(String[] args) {
        Runner runner = new Runner();
        System.out.printf("NOTE: Output files may not appear in the " +
                "file viewer until termination of program%n" +
                "Please terminate the program if they do not " +
                "appear and you want to see them%n");
        do {
            int exerciseNumber = runner.readExercise();
            runner.exerciseRunner(exerciseNumber);
        } while(runner.runAgain());
    }

    private int readExercise() {
        return in.readIntValidatedWithCondition(
                buildPrompt(),
                "That is not a valid exercise number, please try again",
                VALIDATE_EXERCISE);
    }

    private void exerciseRunner(int exerciseNumber) {
        if (exerciseNumber == -1) {
            for(int i = MIN_EXERCISE; i <= MAX_EXERCISE; i++) {
                runExercise(i);
            }
        } else {
            runExercise(exerciseNumber);
        }
    }


    private void runExercise(int exerciseNumber) {
        try {
            Method main = buildMainMethod(exerciseNumber);
            runMainMethod(main, exerciseNumber);
        } catch (ClassNotFoundException | NoSuchMethodException |
                 IllegalAccessException | InvocationTargetException e) {
            System.out.printf("Could not run exercise%n%s%n", e.getMessage());
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
        return String.format("Enter an exercise number (%d-%d, inclusive), or -1 for all: ",
                MIN_EXERCISE, MAX_EXERCISE);
    }
}
