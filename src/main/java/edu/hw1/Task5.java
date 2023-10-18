package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int input) {
        String currentString = Integer.valueOf(input).toString();

        while (currentString.length() > 1) {
            if (isPalindrome(currentString)) {
                return true;
            }

            currentString = nextChild(currentString);
        }
        return false;
    }

    private static boolean isPalindrome(String input) {
        String firstHalf = input.substring(0, input.length() / 2);
        String secondHalf =
            input.substring((input.length() % 2 == 0) ? input.length() / 2 : input.length() / 2 + 1, input.length());

        StringBuilder builder = new StringBuilder(secondHalf);
        builder.reverse();
        secondHalf = builder.toString();

        return firstHalf.equals(secondHalf);
    }

    private static String nextChild(String input) {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < input.length(); i += 2) {
            int newChar = Character.getNumericValue(input.charAt(0)) + Character.getNumericValue(input.charAt(1));

            current.append(Integer.toString(newChar));
        }
        return current.toString();
    }
}
