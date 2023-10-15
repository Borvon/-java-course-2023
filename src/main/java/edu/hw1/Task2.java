package edu.hw1;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int input) {
        int n = 1;
        int currentValue = input;
        final int radix = 10;
        while ((currentValue /= radix) != 0) {
            n++;
        }
        return n;
    }

}
