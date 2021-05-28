package com.rebwon.design.chap12.realworld;

import com.rebwon.design.chap12.realworld.CarStateFactory.CarStateID;

public final class Car {

    private int speed;
    private CarState normalState;
    private CarState limpState;
    private CarState currentState;

    public Car() {
        normalState = CarStateFactory.getState(CarStateID.NORMAL, this);
        limpState = CarStateFactory.getState(CarStateID.LIMP_MODE, this);
        currentState = normalState;
    }

    public CarState getLimpState() {
        return limpState;
    }

    public void setState(CarState carState) {
        this.currentState = carState;
    }

    public void speedDown(int targetSpeed) {
        currentState.speedDown(targetSpeed);
    }

    public void speedUp(int targetSpeed) {
        currentState.speedUp(targetSpeed);
    }

    public void engineRepaired() {
        currentState.engineRepaired();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public CarState getNormalState() {
        return normalState;
    }

    public void engineFailedDetected() {
        currentState.engineFailedDetected();
    }
}
