package com.rebwon.concurrency;

public final class SynchronizedCounter implements Counter {

    private volatile int i = 0;

    @Override
    public synchronized int increment() {
        return i = i + 1;
    }

    @Override
    public synchronized int get() {
        return i;
    }
}
