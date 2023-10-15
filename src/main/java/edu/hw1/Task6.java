package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    public static int countK(int input) {

        int n = input;

        final int K = 6174;
        final int numberSize = 4;
        final int radix = 10;
        if (n == K) {
            return 0;
        }

        char[] digits = new char[numberSize];

        for (int i = 0; i < numberSize; i++) {
            digits[i] = Character.forDigit(n % radix, radix);
            n /= radix;
        }

        Arrays.sort(digits);

        StringBuilder forward = new StringBuilder();
        StringBuilder backward = new StringBuilder();

        for (int i = 0; i < numberSize; i++) {
            forward.append(digits[i]);
            backward.append(digits[numberSize - i - 1]);
        }

        int dif = Math.abs(Integer.parseInt(forward.toString()) - Integer.parseInt(backward.toString()));

        return countK(dif) + 1;
    }

}
