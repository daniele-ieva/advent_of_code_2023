package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        var tester = new ExtractionTester();
        File source = new File("aoc_day_2/part 2/puzzle_input");
        Scanner scanner = new Scanner(source);
        int sum = 0;
        String line;
        String[] game_input;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            game_input = line.split(":");
            sum += tester.test(game_input[1]);
        }
        System.out.println(sum);
    }
}
