package com.adventofcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ExtractionTester {
    private final HashMap<String, Integer> map = new HashMap<>();

    public int test(String input) {
        int power;
        String[] extractions = input.split(";");
        String[] keypairs;
        String[] key_values;
        var keys = new ArrayList<String>();
        var values = new ArrayList<Integer>();

        map.put("red", 0);
        map.put("green", 0);
        map.put("blue", 0);

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

        for (int i = 0; i < keys.size(); i++) {
            if (values.get(i) > map.get(keys.get(i))) {
                map.put(keys.get(i), values.get(i));
            }
        }
        System.out.println(map);
        power = map.get("red") * map.get("green") * map.get("blue");
        return power;
    }
}
