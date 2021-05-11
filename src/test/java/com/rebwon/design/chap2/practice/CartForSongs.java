package com.rebwon.design.chap2.practice;

import java.util.ArrayList;
import java.util.List;

public final class CartForSongs {
    private List<Song> cart = new ArrayList<>();

    public double calculateTotalPrice() {
        return cart.stream()
            .mapToDouble(Song::calculatePrice)
            .sum();
    }

    public void add(Song song) {
        cart.add(song);
    }
}
