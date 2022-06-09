package com.rebwon.object.chap1;

import java.util.ArrayList;
import java.util.List;

public final class TicketOffice {

    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();
    private Theater theater;

    public TicketOffice(Long amount) {
        this.amount = amount;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Ticket getTicketWithFee() {
        if (tickets.size() == 0) return Ticket.EMPTY;
        else {
            Ticket ticket = tickets.remove(0);
            amount += ticket.getFee();
            return ticket;
        }
    }

    public Ticket getTicketWithNoFee() {
        if (tickets.size() == 0) return Ticket.EMPTY;
        return tickets.remove(0);
    }

    public Long getTicketPrice() {
        if (tickets.size() == 0) return 0L;
        return tickets.get(0).getFee();
    }

    public void contract(Theater theater) {
        this.theater = theater;
    }
}
