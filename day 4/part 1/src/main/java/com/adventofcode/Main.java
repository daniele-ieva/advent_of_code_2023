package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("day 4/part 1/puzzle_input");
        Scanner scanner = new Scanner(source);
        int sum = 0;
        while (scanner.hasNext()) {
            sum += WinningNumbers.result(scanner.nextLine().split(":")[1]);
        }
        System.out.println(sum);
    }
}
