package com.rebwon.design.chap6.rebwon;

import java.util.Objects;

public final class Ticket {

    private final int serialNumber;

    public Ticket(int serialNumber) {
        if(serialNumber <= 0) {
            throw new RuntimeException("serial number is greater than zero");
        }
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return serialNumber == ticket.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "serialNumber=" + serialNumber +
            '}';
    }
}
