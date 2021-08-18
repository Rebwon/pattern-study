package com.rebwon.something;

import org.junit.jupiter.api.Test;

public final class ThreadTests {

    static class Counter {
        private static Object object = new Object();
        static volatile int count = 0;

        public void increment() {
            synchronized (object) {
                count++;
            }
        }
    }

    static class MyRunnable implements Runnable {
        Counter counter;

        public MyRunnable(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i=0; i<10000; i++) {
                counter.increment();
            }
        }
    }

    @Test
    void name() throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyRunnable(new Counter()));
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Counter count :" + Counter.count);
    }
}
