package com.adventofcode;

import java.util.List;

public class EngineFixer {
    private int width, height;
    private int[][] schematic;

    public EngineFixer(List<String> input) {
        height = input.size();
        width = input.get(0).length();
        System.out.printf("%d : %d\n", width, height);
        schematic = new int[width][height];
        char in;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                in = input.get(y).toCharArray()[x];
                if (in == '.') {
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

    public int fix() {
        int sum = 0;
        int number;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (schematic[x][y] >= 0 && checkNeighbors(x, y)) {
                    number = findNumber(x, y);
                    sum += number;
                    System.out.println(number);
                }
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.printf("%2d", schematic[x][y]);
            }
            System.out.println();
        }
        return sum;
    }

    private boolean checkNeighbors(int x, int y) {
        boolean found = false;
        for (int of_y = -1; of_y <= 1; of_y++) {
            for (int of_x = -1; of_x <= 1; of_x++) {
                if (x + of_x >= 0 && x + of_x < width && y + of_y >= 0 && y + of_y < height) {
                    if (schematic[x + of_x][y + of_y] < -1) {
                        return true;
                    }
                }
            }
        }
        return found;
    }

    private int findNumber(int x, int y) {
        int offset = 1;
        int tens = 10;
        int value = schematic[x][y];
        while (x + offset < width && schematic[x + offset][y] >= 0) {
            value *= 10;
            value += schematic[x + offset][y];
            tens *= 10;
            schematic[x + offset][y] = -1;
            offset++;
        }
        offset = -1;
        while (x + offset >= 0 && schematic[x + offset][y] >= 0) {
            value += schematic[x + offset][y] * tens;
            tens *= 10;
            schematic[x + offset][y] = -1;
            offset--;
        }
        schematic[x][y] = -1;
        return value;
    }
}
