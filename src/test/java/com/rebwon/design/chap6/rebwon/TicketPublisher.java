package com.rebwon.design.chap6.rebwon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class TicketPublisher {
    private static TicketPublisher instance = null;
    private static final List<Ticket> tickets = new ArrayList<>();
    private static final int MAXIMUM_SIZE = 20;

    private TicketPublisher() {}

    static {
        for(int i=0; i< MAXIMUM_SIZE; i++) {
            tickets.add(new Ticket(ThreadLocalRandom.current().nextInt(1, 200)));
        }
    }

    public synchronized static TicketPublisher getInstance() {
        if(instance == null)
            instance = new TicketPublisher();
        return instance;
    }

    public synchronized Ticket getTicket() {
        if(tickets.size() == 0)
            throw new IllegalStateException("Ticket is over");
        return tickets.remove(tickets.size() -1);
    }
}
