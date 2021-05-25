package com.rebwon.design.chap8.realworld;

import java.util.ArrayList;
import java.util.List;

public final class ElevatorManager {

    private List<ElevatorController> controllers;

    public ElevatorManager(int controllerCount) {
        this.controllers = new ArrayList<>(controllerCount);
    }

    public void addController(ElevatorController controller) {
        controllers.add(controller);
    }

    public void requestElevator(int destination, Direction direction) {
        int selectedElevator = selectElevator(destination, direction);

        controllers.get(selectedElevator).gotoFloor(destination);
    }

    private int selectElevator(int destination, Direction direction) {
        return 0;
    }
}
