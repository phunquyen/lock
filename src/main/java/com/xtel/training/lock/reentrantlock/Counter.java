package com.xtel.training.lock.reentrantlock;

public class Counter {
    private int count;
    public Counter(){
        count = 0;
    }

    public void increment() {
        count ++;
    }

    public int get() {
        return count;
    }
}
