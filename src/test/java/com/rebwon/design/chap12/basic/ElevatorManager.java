package com.rebwon.design.chap12.basic;

import com.rebwon.design.chap8.realworld.Direction;
import java.util.ArrayList;
import java.util.List;

public final class ElevatorManager {

    private List<ElevatorController> controllers;
    private SchedulingStrategyID strategyID;

    public ElevatorManager(int controllerCount, SchedulingStrategyID strategyID) {
        controllers = new ArrayList<>(controllerCount);

        for (int i = 0; i < controllerCount; i++) {
            controllers.add(new ElevatorController(i + 1));
        }
        this.strategyID = strategyID;
    }

    public void setStrategyID(SchedulingStrategyID strategyID) {
        this.strategyID = strategyID;
    }

    void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}
