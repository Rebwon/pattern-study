package com.rebwon.design.chap6.rebwon;

public final class User {
    private final String username;
    private Ticket ticket;

    public User(String username) {
        this.username = username;
    }

    public void publishTicket(TicketPublisher publisher) {
        ticket = publisher.getTicket();
    }

    @Override
    public String toString() {
        return "User{" +
            "username='" + username + '\'' +
            ", ticket=" + ticket +
            '}';
    }

    public boolean hasTicket() {
        return this.ticket != null;
    }
}
