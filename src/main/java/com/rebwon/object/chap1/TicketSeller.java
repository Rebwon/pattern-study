package com.rebwon.object.chap1;

public interface TicketSeller {

    void sellTo(Audience audience);

    static TicketSeller create(TicketOffice ticketOffice) {
        return new TicketSellerImpl(ticketOffice);
    }
}

class TicketSellerImpl implements TicketSeller {

    private final TicketOffice ticketOffice;

    public TicketSellerImpl(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    @Override
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}