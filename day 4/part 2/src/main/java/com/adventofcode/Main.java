package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("day 4/part 2/puzzle_input");
        Scanner scanner = new Scanner(source);
        int count = 0;

        ArrayList<String> tickets = new ArrayList<>();
        while (scanner.hasNext()) {
            tickets.add(scanner.nextLine().split(":")[1]);
        }
        ArrayList<Integer> counter = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            counter.add(1);
        }
        int to_add;
        for (int i = 0; i < tickets.size(); i++) {
            to_add = WinningNumbers.result(tickets.get(i));
            for (int j = 1; j < to_add + 1; j++) {
                if (i + j < counter.size()) {
                    counter.set(i + j, counter.get(i + j) + counter.get(i));
                }
            }
        }

        for (var num : counter) {
            count += num;
        }
        System.out.println(count);
    }
}
