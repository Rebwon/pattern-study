package com.rebwon.object.chap1;

public interface Ticket {

    int fee();

    static Ticket create(int fee) {
        return new TicketImpl(fee);
    }
}

class TicketImpl implements Ticket {

    private final int fee;

    public TicketImpl(int fee) {
        this.fee = fee;
    }

    @Override
    public int fee() {
        return this.fee;
    }
}
