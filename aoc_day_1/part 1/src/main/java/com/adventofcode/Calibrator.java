package com.adventofcode;

import lombok.NonNull;

public class Calibrator {
    public static int findDigits(@NonNull String line) {
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
