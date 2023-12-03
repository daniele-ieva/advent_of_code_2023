package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        var input = Files.readAllLines(Paths.get("aoc_day_3/part 1/puzzle_input"));
        var fixer = new EngineFixer(input);
        System.out.println(fixer.fix());
    }
}