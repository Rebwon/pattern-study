package com.rebwon.design.chap6.book;

public final class UserThread extends Thread {

    private Ticket myTicket;

    public UserThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        TicketManager manager = TicketManager.getInstance();
        myTicket = manager.getTicket();
    }

    public Ticket getMyTicket() {
        return myTicket;
    }
}
