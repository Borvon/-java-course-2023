package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String input) {
        if (input == null) {
            throw new NullPointerException("Input string cannot be null");
        }

        int len = (input.length() % 2 == 0) ? input.length() : input.length() - 1;

        StringBuilder builder = new StringBuilder(input);

        for (int i = 0; i < len; i += 2) {

            builder.setCharAt(i, input.charAt(i + 1));
            builder.setCharAt(i + 1, input.charAt(i));
        }

        return builder.toString();
    }
}
