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
            input = input.replaceAll(numbers[i], numbers[i] + String.valueOf(i));
        }
        return input;
    }

    public static int findDigits(@NonNull String line) {
        line = lettersToNumbers(line);
        int first = -1, last = -1;
        for (char c : line.toCharArray()) {
            if (c >= '0' && c <= '9') {
                last = (int) c - '0';
                if (first == -1) {
                    first = last;
                }
            }
        }
        return first * 10 + last;
    }
}
