package com.rebwon.design.chap13.basic;

public final class LGElevatorFactory extends ElevatorFactory {

    @Override
    public Motor createMotor() {
        return new LGMotor();
    }

    @Override
    public Door createDoor() {
        return new LGDoor();
    }
}
