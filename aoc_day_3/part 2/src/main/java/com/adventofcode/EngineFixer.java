package com.adventofcode;

import java.util.List;

public class EngineFixer {
    private final int width;
    private final int height;
    private final int[][] schematic;

    public EngineFixer(List<String> input) {
        height = input.size();
        width = input.get(0).length();
        schematic = new int[width][height];
        char in;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                in = input.get(y).toCharArray()[x];
                if (in == '*') {
                    schematic[x][y] = -1;
                    continue;
                }

                if (in >= '0' && in <= '9') {
                    schematic[x][y] = in - '0';
                    continue;
                }

                schematic[x][y] = -2;
            }
        }
    }
    
    // Start the program
    public int fix() {
        int sum = 0;
        int number;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (schematic[x][y] == -1) {
                    number = checkNeighbors(x, y);
                    sum += number;
                }
            }
        }
        return sum;
    }

    // Check if there are exactly two numbers neighboring the * character (diagonals included), if so return
    // their product
    private int checkNeighbors(int x, int y) {
        boolean found = false;
        int ratio = 1;
        int count = 0;
        for (int of_y = -1; of_y <= 1; of_y++) {
            for (int of_x = -1; of_x <= 1; of_x++) {
                if (x + of_x >= 0 && x + of_x < width && y + of_y >= 0 && y + of_y < height) {
                    if (schematic[x + of_x][y + of_y] >= 0) {
                        count++;
                        ratio *= findNumber(x + of_x, y + of_y);
                        while (of_x <= 1 && x + of_x < width && schematic[x + of_x][y + of_y] >= 0) {
                            of_x++;
                        }
                    }
                }
            }
        }
        if (count == 2) {
            return ratio;
        }
        return 0;
    }

    // Find the number comprising the digit found in position x, y of the grid
    private int findNumber(int x, int y) {
        int offset = 1;
        int tens = 10;
        int value = schematic[x][y];
        while (x + offset < width && schematic[x + offset][y] >= 0) {
            value *= 10;
            value += schematic[x + offset][y];
            tens *= 10;
            offset++;
        }
        offset = -1;
        while (x + offset >= 0 && schematic[x + offset][y] >= 0) {
            value += schematic[x + offset][y] * tens;
            tens *= 10;
            offset--;
        }
        return value;
    }
}
