package com.rebwon.design.chap12.basic;

public final class ElevatorController {
    private int id;
    private int curFloor;

    public ElevatorController(int id) {
        this.id = id;
        this.curFloor = 1;
    }

    public void gotoFloor(int destination) {
        curFloor = destination;
    }
}
