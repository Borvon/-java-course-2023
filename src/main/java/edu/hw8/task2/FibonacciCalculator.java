package edu.hw8.task2;

public class FibonacciCalculator {

    private FibonacciCalculator() {

    }

    public static int calculateFor(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return calculateFor(n - 1) + calculateFor(n - 2);
        }
    }

}
