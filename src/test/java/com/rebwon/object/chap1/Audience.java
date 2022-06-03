package com.rebwon.object.chap1;

public final class Audience {

    private Invitation invitation;
    private Ticket ticket;

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public void buyTicket(TicketSeller ticketSeller) {
        ticket = ticketSeller.getTicket(this);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void removeInvitation() {
        invitation = Invitation.EMPTY;
    }

    public void minusAmount(Long ticketPrice) {

    }

    public boolean hasAmount(Long ticketPrice) {
        return false;
    }
}
