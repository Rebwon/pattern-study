package com.rebwon.object.chap1;

public interface Audience {

    static Audience create(Bag bag) {
        return new AudienceImpl(bag);
    }

    int buy(Ticket ticket);
}

class AudienceImpl implements Audience {

    private final Bag bag;

    public AudienceImpl(Bag bag) {
        this.bag = bag;
    }

    @Override
    public int buy(Ticket ticket) {
        // TODO Auto-generated method stub
        return bag.hold(ticket);
    }

}

