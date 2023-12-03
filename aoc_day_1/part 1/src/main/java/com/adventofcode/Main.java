package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("aoc_day_1/part 1/puzzle_input");
        Scanner scanner = new Scanner(source);
        int sum = 0;
        while (scanner.hasNext()) {
            sum += Calibrator.findDigits(scanner.nextLine());
        }
        System.out.printf("The sum is: %d\n", sum);
    }
}