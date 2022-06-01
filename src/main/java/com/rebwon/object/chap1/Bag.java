package com.rebwon.object.chap1;

public interface Bag {
    int hold(Ticket ticket);

    static Bag create(int amount) {
        return new BagImpl(amount);
    }

    static Bag create(int amount, Invitation invitation) {
        return new BagImpl(amount, invitation);
    }

}

class BagImpl implements Bag {

    private int amount;
    private Ticket ticket;
    private Invitation invitation;

    public BagImpl(int amount) {
        this(amount, null);
    }

    public BagImpl(int amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    @Override
    public int hold(Ticket ticket) {
        if (invitation != null) {
            setTicket(ticket);
            return 0;
        } else {
            setTicket(ticket);
            minusAmount(ticket.fee());
            return ticket.fee();
        }
    }

    private void minusAmount(int fee) {
        this.amount -= fee;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
