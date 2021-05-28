package com.rebwon.design.chap11.basic;

import com.rebwon.design.chap8.realworld.Direction;

public final class ResponseTimeScheduler implements ElevatorScheduler {

    private static ResponseTimeScheduler scheduler;

    private ResponseTimeScheduler() {}

    public static synchronized ResponseTimeScheduler getInstance() {
        if(scheduler == null)
            scheduler = new ResponseTimeScheduler();
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination,
        Direction direction) {
        return 0;
    }
}
