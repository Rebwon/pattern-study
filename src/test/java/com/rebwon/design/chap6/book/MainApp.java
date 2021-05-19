package com.rebwon.design.chap6.book;

public final class MainApp {
    private static final int THREAD_NUM = 15;

    public static void main(String[] args) {
        TicketManager manager = TicketManager.getInstance();
        manager.setLimits(5);
        UserThread[] userThreads = new UserThread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            userThreads[i] = new UserThread((i+1) + "-thread");
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
            if (userThreads[i].getMyTicket().getTicketNumber() != 0) {
                System.out.println("User" + i + "-th thread get ticket" + userThreads[i].getMyTicket().getTicketNumber());
            }
        }
    }
}
