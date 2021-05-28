package com.rebwon.design.chap12.realworld;

public abstract class CarState {

    protected Car car;

    public CarState(Car car) {
        this.car = car;
    }

    public void speedDown(int targetSpeed) {
        System.out.println("Speed: " + car.getSpeed());
        if(targetSpeed < car.getSpeed())
            car.setSpeed(targetSpeed);

        System.out.println("==>" + car.getSpeed());
    }

    abstract void speedUp(int targetSpeed);

    abstract void engineFailedDetected();

    abstract void engineRepaired();

}
