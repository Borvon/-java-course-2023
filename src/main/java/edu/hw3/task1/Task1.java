package edu.hw3.task1;

public class Task1 {

    private Task1() {

    }

    public static String atbash(String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                builder.append((char) ('Z' - character + 'A'));
            } else if (character >= 'a' && character <= 'z') {
                builder.append((char) ('z' - character + 'a'));
            } else {
                builder.append(character);
            }
        }

        return builder.toString();
    }
}
