package com.rebwon.object.chap1;

import java.util.ArrayList;
import java.util.List;

public final class Theater {

    private final List<TicketOffice> ticketOffices = new ArrayList<>();
    private final Long fee;

    public Theater(Long fee) {
        this.fee = fee;
    }

    Long getFee() {
        return fee;
    }

    public void setTicketOffices(TicketOffice... ticketOffices) {
        for (TicketOffice ticketOffice : ticketOffices) {
            ticketOffice.contract(this);
            this.ticketOffices.add(ticketOffice);
        }
    }

    public void setTicket(TicketOffice ticketOffice, Long num) {
        if (!ticketOffices.contains(ticketOffice)) return;
        while (num-- > 0) {
            ticketOffice.addTicket(new Ticket(this));
        }
    }

    public void setInvitation(Audience audience) {
        audience.setInvitation(new Invitation(this));
    }

    public boolean enter(Audience audience) {
        Ticket ticket = audience.getTicket();
        return ticket.isValid(this);
    }
}
