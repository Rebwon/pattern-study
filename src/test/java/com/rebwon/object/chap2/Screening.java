package com.rebwon.object.chap2;

import java.time.LocalDateTime;

public final class Screening {

    private int seat;
    final int sequence;
    final LocalDateTime when;

    public Screening(int sequence, LocalDateTime when, int seat) {
        this.sequence = sequence;
        this.when = when;
        this.seat = seat;
    }

    boolean hasSeat(int count) {
        return seat >= count;
    }

    void reserveSeat(int count) {
        if (hasSeat(count)) seat -= count;
        else throw new RuntimeException("no seat");
    }
}
