package com.rebwon.design.chap6.book;

public final class NormalTicket implements Ticket {

    private final int serialNumber;

    public NormalTicket(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int getTicketNumber() {
        return serialNumber;
    }
}
