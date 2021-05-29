package com.rebwon.design.chap13.basic;

public abstract class ElevatorFactory { // Abstract Factory

    public abstract Motor createMotor();

    public abstract Door createDoor();
}
