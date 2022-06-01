package com.rebwon.object.chap1;

public interface Theater {

    void enter(Audience audience);

    static Theater create(TicketSeller ticketSeller) {
        return new TheaterImpl(ticketSeller);
    }
}

class TheaterImpl implements Theater {

    private final TicketSeller ticketSeller;

    public TheaterImpl(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    @Override
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}