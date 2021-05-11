package com.rebwon.design.chap2.practice;

import java.util.ArrayList;
import java.util.Iterator;

public final class CartForSongs {
    private ArrayList<Song> cart = new ArrayList<>();

    public double calculateTotalPrice() {
        double total = 0.0;
        Iterator<Song> iterator = cart.iterator();

        while(iterator.hasNext()) {
            Song s = iterator.next();
            total += s.calculatePrice();
        }

        return total;
    }

    public void add(Song song) {
        cart.add(song);
    }
}
