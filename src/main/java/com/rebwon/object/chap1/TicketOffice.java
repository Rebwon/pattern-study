package com.rebwon.object.chap1;

import java.util.ArrayList;
import java.util.List;

public interface TicketOffice {
    void sellTicketTo(Audience audience);

    static TicketOffice create() {
        return new TicketOfficeImpl(10000, Ticket.create(5000), Ticket.create(5000),
            Ticket.create(5000), Ticket.create(5000), Ticket.create(5000));
    }

}

class TicketOfficeImpl implements TicketOffice {

    private int amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOfficeImpl(int amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(List.of(tickets));
    }

    private Ticket getOne() {
        return tickets.remove(0);
    }

    @Override
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getOne()));
    }

    private void plusAmount(int amount) {
        this.amount += amount;
    }

    private void minusAmount(int amount) {
        this.amount -= amount;
    }

}
