package com.rebwon.object;

import com.rebwon.object.chap1.Audience;
import com.rebwon.object.chap1.Bag;
import com.rebwon.object.chap1.Theater;
import com.rebwon.object.chap1.TicketOffice;
import com.rebwon.object.chap1.TicketSeller;

public final class MainApp {

    public static void main(String[] args) {
        Audience audience = Audience.create(Bag.create(10000));
        Theater theater = Theater.create(TicketSeller.create(TicketOffice.create()));
        theater.enter(audience);
    }
}
