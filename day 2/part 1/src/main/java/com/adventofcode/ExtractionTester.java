package com.adventofcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ExtractionTester {
    private final HashMap map = new HashMap<String, Integer>();

    public ExtractionTester(int red, int green, int blue) {
        map.put("red", red);
        map.put("green", green);
        map.put("blue", blue);
    }


    // Return true if all the extractions described by the input string are valid given the number of marbles set in
    // the constructor
    public boolean test(String input) {
        String[] extractions = input.split(";");
        String[] keypairs;
        String[] key_values;
        var keys = new ArrayList<String>();
        var values = new ArrayList<Integer>();

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
            if (values.get(i) > (Integer) map.get(keys.get(i))) {
                return false;
            }
        }
        return true;
    }
}
