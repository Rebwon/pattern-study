package com.rebwon.object.chap2;

import java.time.Duration;
import java.time.LocalDateTime;

public final class MainApp {

    public static void main(String[] args) {
        Theater theater = new Theater(Money.of(100.0));
        Movie movie = new Movie<AmountDiscount>(
            "Avengers End-Game",
            Duration.ofMinutes(120L),
            Money.of(5000.0),
            new SequenceAmountDiscount(Money.of(1000.0), 1)
        );
        theater.addMovie(movie);
        for (int day=7; day<32; day++) {
            for (int hour=10, seq=1; hour<24; hour+=3, seq++) {
                theater.addScreening(
                    movie,
                    new Screening(
                        seq,
                        LocalDateTime.of(2022, 6, day, hour, 00, 00),
                        100
                    )
                );
            }
        }

        TicketOffice ticketOffice = new TicketOffice(Money.of(0.0));
        theater.contractTicketOffice(ticketOffice, 10.0);
        TicketSeller ticketSeller = new TicketSeller();
        ticketSeller.setTicketOffice(ticketOffice);
        Customer customer = new Customer();

        for (Screening screening : theater.getScreening(movie)) {
            customer.reserve(ticketSeller, theater, movie, screening, 2);
            boolean isOk = theater.enter(customer, 2);
            System.out.println(isOk);
            break;
        }
    }
}
