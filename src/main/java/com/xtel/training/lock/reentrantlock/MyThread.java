package com.xtel.training.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable{
    private Counter counter;
    private ReentrantLock lock;

    public MyThread(Counter counter, ReentrantLock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        try {
            counter.increment();
        } finally {
            lock.unlock();
        }
    }

}
