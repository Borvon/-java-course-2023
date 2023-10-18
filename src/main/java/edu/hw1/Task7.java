package edu.hw1;

public class Task7 {
    private static final int INT_SIZE = 31;

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int digitCount = calculateDigitCount(n);

        return ((n << shift) & (Integer.MAX_VALUE >> (INT_SIZE - digitCount))) | (n >> digitCount - shift);
    }

    public static int rotateRight(int n, int shift) {
        int digitCount = calculateDigitCount(n);

        return (n >> shift) | ((n << digitCount - shift) & (Integer.MAX_VALUE >> (INT_SIZE - digitCount)));
    }

    private static int calculateDigitCount(int input) {
        int number = input;
        int digitsCount = 0;

        while (number != 0) {
            digitsCount++;
            number /= 2;
        }
        return digitsCount;
    }
}
