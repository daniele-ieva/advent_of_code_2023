package com.adventofcode;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNext()) {
            sum += Calibrator.findDigits(scanner.nextLine());
        }
        System.out.printf("The sum is: %d\n", sum);
    }
}