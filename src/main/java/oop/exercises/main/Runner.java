/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
package oop.exercises.main;

import oop.exercises.util.DataReader;
import java.util.function.IntPredicate;


public class Runner {

    private static final DataReader in = new DataReader();
    private static final int MIN_EXERCISE = 41;
    private static final int MAX_EXERCISE = 46;
    private static final IntPredicate VALID_EXERCISE =
            (x) -> MIN_EXERCISE <= x && x <= MAX_EXERCISE;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.runExercise(runner.readExercise());
    }

    private int readExercise() {
        return in.readIntValidatedWithCondition(
                "Enter an exercise number (41-46, inclusive): ",
                "That is not a valid exercise number, please try again",
                VALID_EXERCISE);
    }

    private void runExercise(int exerciseNumber) {
        String[] args = new String[0];

        System.out.printf("Running exercise %d...%n%n", exerciseNumber);
        switch (exerciseNumber) {
            case 41 -> oop.exercises.ex41.Application.main(args);
            case 42 -> oop.exercises.ex42.Application.main(args);
            case 43 -> oop.exercises.ex43.Application.main(args);
            case 44 -> oop.exercises.ex44.Application.main(args);
            case 45 -> oop.exercises.ex45.Application.main(args);
            case 46 -> oop.exercises.ex46.Application.main(args);
            default -> throw new IllegalArgumentException("Exercise not valid");
        }
    }
}
