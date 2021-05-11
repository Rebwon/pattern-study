package com.rebwon.design.chap2.practice;

import java.util.ArrayList;
import java.util.Iterator;

public final class CartForSongs {
    ArrayList<Song> cart = new ArrayList<>();   // cart의 가시성이 package-private이긴 하나, private으로 아예 숨겨버리자.

    public double calculateTotalPrice() {
        double total = 0.0;
        Iterator<Song> iterator = cart.iterator();

        while(iterator.hasNext()) {
            Song s = iterator.next();

            if(s.getDiscountMode().equals("OnSale"))    // Song의 DiscountMode를 비교하는 if-else 구문을 지워버리자. 또한 Song의 내부 가격까지 알 필요는 없다.
                total += (s.getPrice() - 0.1 * s.getPrice());
            else if(s.getDiscountMode().equals("TodayEvent"))
                total += (s.getPrice() - 0.3 * s.getPrice());
            else
                total += s.getPrice();
        }

        return total;
    }

    public void add(Song song) {
        cart.add(song);
    }
}
