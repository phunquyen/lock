package com.xtel.training.lock.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MainApplication {
    private static final int threads = 5;
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ReentrantLock lock = new ReentrantLock(true);

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.submit(new MyThread(counter, lock));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(counter.get());
    }
}
