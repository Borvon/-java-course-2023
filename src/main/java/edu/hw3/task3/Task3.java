package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {

    }

    public static Map<Object, Integer> freqDict(List<Object> input) {
        Map<Object, Integer> frequences = new HashMap<>();

        for (Object currentObj : input) {
            if (frequences.containsKey(currentObj)) {
                frequences.put(currentObj, frequences.get(currentObj) + 1);
            } else {
                frequences.put(currentObj, 1);
            }
        }

        return frequences;
    }
}
