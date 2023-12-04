package com.adventofcode;

import java.util.Arrays;

public class WinningNumbers {


    public static int result(String input) {
        String[] tmp = input.split("\\|");
        int result = 0;
        var winning = Arrays.stream(tmp[0].split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt).toArray();
        var numbers = Arrays.stream(tmp[1].split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt).toArray();

        for (var win : winning) {
            for (var num : numbers) {
                if (win.equals(num)) {
                    result++;
                }
            }
        }
        return result;
    }
}
