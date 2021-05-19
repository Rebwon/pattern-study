package com.rebwon.design.chap6.rebwon;

public final class Sample extends Thread {

    private Ticket ticket;

    public Sample(String name) {
        super(name);
    }

    @Override
    public void run() {
        TicketPublisher publisher = TicketPublisher.getInstance();
        ticket = publisher.getTicket();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean hasTicket() {
        return ticket != null;
    }
}
