package edu.hw7.task4;

import java.util.Random;

public class SingleThreadedPiCalculator implements PiCalculator {

    private final static int RADIUS = 1000000;

    @Override
    @SuppressWarnings("MagicNumber")
    public double calculate(int iterations) {
        Random random = new Random();
        int circleCount = 0;
        int totalCount = 0;

        for (int i = 0; i < iterations; i++) {
            int x = random.nextInt() % RADIUS;
            int y = random.nextInt() % RADIUS;

            if ((long) x * x + (long) y * y <= (long) RADIUS * RADIUS) {
                circleCount++;
            }
            totalCount++;
        }

        return 4 * ((double) circleCount / totalCount);

    }
}
