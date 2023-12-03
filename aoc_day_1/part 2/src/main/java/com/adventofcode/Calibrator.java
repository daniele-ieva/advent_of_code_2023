package com.adventofcode;

import lombok.NonNull;

public class Calibrator {
    public static final String[] numbers = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    public static String lettersToNumbers(String input) {
        for (int i = 0; i < numbers.length; i++) {
            input = input.replaceAll(numbers[i], numbers[i] + i + numbers[i]);
        }
        input = input.replaceAll("[^0-9]", "");
        return input;
    }

    // Find the first and last digit of the given string and return the number they form (e.g. ad2c4e will give out 24)
    // Also consider literal representation of the numbers as valid
    public static int findDigits(@NonNull String line) {
        line = lettersToNumbers(line);
        int first = Integer.parseInt(line.substring(0, 1));
        int last = Integer.parseInt(line.substring(line.length() - 1));
        System.out.println(first * 10 + last);
        return first * 10 + last;
    }
}
