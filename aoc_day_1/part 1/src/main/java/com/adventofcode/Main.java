package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("aoc_day_1/part 1/puzzle_input");
        Scanner scanner = new Scanner(source);
        int count = 0;
        int missing = 1;
        while (scanner.hasNext() && missing > 0) {
            missing += Calibrator.findDigits(scanner.nextLine());
            count++;
        }
        System.out.printf("The sum is: %d\n", count);
    }
}