package com.rebwon.design.chap2.practice;

public final class Song {

    private DiscountMode mode;

    public Song(DiscountMode mode) {
        this.mode = mode;
    }

    double getPrice() {
        return 10.0;
    }

    public double calculatePrice() {
        return mode.calculate(getPrice());
    }

}
