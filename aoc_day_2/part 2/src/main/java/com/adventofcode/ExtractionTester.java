package com.adventofcode;


import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ExtractionTester {
    private final HashMap<String, Integer> map = new HashMap<>();

    // Calculate the minimum number of marbles of the different colors(red, green and blue) necessary for the given
    // extractions
    public int test(@NonNull String input) {
        int power;
        String[] extractions = input.split(";");

        map.put("red", 0);
        map.put("green", 0);
        map.put("blue", 0);

        DoubleList keypairs = getKeypairs(extractions);
        var keys = keypairs.stringList;
        var values = keypairs.integerList;

        for (int i = 0; i < keys.size(); i++) {
            if (values.get(i) > map.get(keys.get(i))) {
                map.put(keys.get(i), values.get(i));
            }
        }
        System.out.println(map);
        power = map.get("red") * map.get("green") * map.get("blue");
        return power;
    }


    // Parse the input string, separating the different extractions and colors
    DoubleList getKeypairs(@NonNull String[] extractions) {
        var keys = new ArrayList<String>();
        var values = new ArrayList<Integer>();
        String[] keypairs;
        String[] key_values;
        for (var extraction : extractions) {
            keypairs = extraction.split(", ");
            for (var keypair : keypairs) {
                key_values = keypair.split(" ");
                int i = 0;
                for (var str : key_values) {
                    if (Objects.equals(str, "")) {
                        continue;
                    }
                    if (i == 0) {
                        i = 1;
                        values.add(Integer.parseInt(str));
                    } else {
                        i = 0;
                        keys.add(str);
                    }
                }
            }
        }
        return new DoubleList(keys, values);
    }

    @Getter
    public record DoubleList(ArrayList<String> stringList, ArrayList<Integer> integerList) {
    }
}

