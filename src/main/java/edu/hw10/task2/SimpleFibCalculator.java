package edu.hw10.task2;

public class SimpleFibCalculator implements FibCalculator {

    @Override
    public long fib(int number) {
        if (number <= 1) {
            return number;
        }

        long result = fib(number - 1) + fib(number - 2);
        return result;
    }
}
