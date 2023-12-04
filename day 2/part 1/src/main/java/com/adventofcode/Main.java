package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        var tester = new ExtractionTester(12, 13, 14);
        File source = new File("day 2/part 1/puzzle_input");
        Scanner scanner = new Scanner(source);
        int sum = 0;
        String line;
        String[] game_input;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            game_input = line.split(":");
            int game_number = Integer.parseInt(game_input[0].substring(4).replaceAll("[^0-9]", ""));
            if (tester.test(game_input[1])) {
                sum += game_number;
            }
        }
        System.out.println(sum);
    }
}
