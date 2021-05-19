package com.rebwon.design.chap6.book;

public final class TicketManager {

    private static TicketManager manager;

    private int limits;
    private int count;

    private TicketManager() {
        count = 0;
    }

    public synchronized static TicketManager getInstance() {
        if(manager == null)
            manager = new TicketManager();
        return manager;
    }

    public synchronized void setLimits(int limits) {
        this.limits = limits;
    }

    public synchronized Ticket getTicket() {
        if(this.count < this.limits)
            return new NormalTicket(++count);
        return new NullTicket();
    }
}
