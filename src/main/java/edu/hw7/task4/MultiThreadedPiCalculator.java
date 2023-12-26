package edu.hw7.task4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedPiCalculator implements PiCalculator {

    private final static int RADIUS = 1000000;

    @Override
    @SuppressWarnings("MagicNumber")
    public double calculate(int iterations) {
        int threadsCount = Runtime.getRuntime().availableProcessors();

        AtomicInteger circleCount = new AtomicInteger(0);
        AtomicInteger totalCount = new AtomicInteger(0);

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Thread(() -> {
                int localCircleCount = 0;
                int localTotalCount = 0;
                Random random = ThreadLocalRandom.current();
                for (int j = 0; j < iterations / threadsCount; j++) {
                    int x = random.nextInt() % RADIUS;
                    int y = random.nextInt() % RADIUS;

                    if ((long) x * x + (long) y * y <= (long) RADIUS * RADIUS) {
                        localCircleCount++;
                    }
                    localTotalCount++;
                }
                circleCount.addAndGet(localCircleCount);
                totalCount.addAndGet(localTotalCount);
            });
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return 4 * ((double) circleCount.get() / totalCount.get());

    }
}
