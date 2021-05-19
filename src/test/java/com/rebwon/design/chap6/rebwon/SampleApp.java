package com.rebwon.design.chap6.rebwon;

public final class SampleApp {

    private static final int THREAD_NUM = 15;

    public static void main(String[] args) {
        Sample[] userThreads = new Sample[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            userThreads[i] = new Sample((i+1) + "-thread");
            userThreads[i].start();
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            try {
                userThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            if (userThreads[i].hasTicket()) {
                System.out.println("User" + i + "-th thread get ticket " + userThreads[i].getTicket().getSerialNumber());
            }
        }
    }
}
