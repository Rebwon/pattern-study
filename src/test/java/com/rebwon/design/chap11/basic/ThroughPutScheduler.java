package com.rebwon.design.chap11.basic;

import com.rebwon.design.chap8.realworld.Direction;

public final class ThroughPutScheduler implements ElevatorScheduler {

    private static ThroughPutScheduler scheduler;

    private ThroughPutScheduler() {}

    public static synchronized ThroughPutScheduler getInstance() {
        if(scheduler == null)
            scheduler = new ThroughPutScheduler();
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination,
        Direction direction) {
        return 0;
    }
}
