package edu.hw7.task2;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class FactorialCalculator {

    private FactorialCalculator() {

    }

    public static BigInteger calculate(int n) {
        return LongStream.rangeClosed(1, n)
            .mapToObj(BigInteger::valueOf)
            .parallel()
            .reduce(BigInteger::multiply)
            .get();
    }

}
