package com.rebwon.design.chap8.realworld;

public final class ElevatorController {

    private int id;
    private int currentFloor;

    public ElevatorController(int id) {
        this.id = id;
    }

    public void gotoFloor(int destination) {
        this.currentFloor = destination;
        System.out.println("Elevator [" + id + "] Current floor : " + currentFloor);
    }
}
