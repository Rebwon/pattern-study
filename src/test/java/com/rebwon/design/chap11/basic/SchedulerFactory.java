package com.rebwon.design.chap11.basic;

import java.util.Calendar;

public final class SchedulerFactory {

    private SchedulerFactory() {}

    public static ElevatorScheduler getScheduler(SchedulingStrategyID strategyID) {
        ElevatorScheduler scheduler = null;
        switch (strategyID) {
            case RESPONSE_TIME:
                scheduler = ResponseTimeScheduler.getInstance();
                break;
            case THROUGHPUT:
                scheduler = ThroughPutScheduler.getInstance();
                break;
            case DYNAMIC:
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if(hour < 12)
                    scheduler = ResponseTimeScheduler.getInstance();
                else
                    scheduler = ThroughPutScheduler.getInstance();
                break;
        }
        return scheduler;
    }
}
