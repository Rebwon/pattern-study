package com.rebwon.object.chap2;

public final class Customer {

    Reservation reservation;

    public void reserve(TicketSeller ticketSeller, Theater theater, Movie movie,
        Screening screening, int audienceCount) {
        reservation = ticketSeller.reserve(this, theater, movie, screening, audienceCount);
    }

    public boolean hasAmount(Money price) {
        return false;
    }

    public void minusAmount(Money price) {

    }
}
