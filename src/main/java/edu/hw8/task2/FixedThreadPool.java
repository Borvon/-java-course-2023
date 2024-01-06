package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {

    private final Thread[] threads;
    private final BlockingQueue<Runnable> taskQueue;

    public FixedThreadPool(int threadsNumber) {
        this.threads = new Thread[threadsNumber];
        this.taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < threadsNumber; i++) {
            threads[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = taskQueue.take();
                        task.run();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

    @Override
    public void start() {
        for (var thread : threads) {
            thread.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
