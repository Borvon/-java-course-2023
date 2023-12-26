package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {

    private AtomicInteger counter = new AtomicInteger(0);
    private final int threadsCount;

    Incrementer(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    public void increment() throws InterruptedException {

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Thread(() -> {
                counter.incrementAndGet();
            });
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].join();
        }
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}
