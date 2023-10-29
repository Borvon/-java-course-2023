package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static List<String> clusterize(String input) {
        List<String> result = new ArrayList<>();

        int start = -1;
        int end;
        int depth = 0;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (start == -1 && character == ')') {
                throw new IllegalArgumentException();
            }

            if (character == '(') {
                if (depth == 0) {
                    start = i;
                }
                depth++;
            } else if (character == ')' && start != -1) {
                depth--;
                if (depth == 0) {
                    end = i;

                    result.add(input.substring(start, end + 1));
                    start = -1;
                }
            }
        }

        if (start != -1) {
            throw new IllegalArgumentException();
        }
        return result;
    }

}
