package com.rebwon.design.chap11.realworld;

public final class NormalState extends CarState {

    private static NormalState state;

    private NormalState(Car car) {
        super(car);
    }

    public static synchronized CarState getInstance(Car car) {
        if(state == null)
            state = new NormalState(car);
        return state;
    }

    @Override
    public void speedUp(int targetSpeed) {
        System.out.println("Speed: " + car.getSpeed());
        if(targetSpeed > car.getSpeed())
            car.setSpeed(targetSpeed);

        System.out.println("==>" + car.getSpeed());
    }

    @Override
    void engineFailedDetected() {
        System.out.println("Speed: " + car.getSpeed());
        car.setSpeed(LimpState.LIMP_MODE_MAX_SPEED);
        System.out.println("==>" + car.getSpeed());
        car.setState(car.getLimpState());
    }

    @Override
    public void engineRepaired() {
        System.out.println("Unexpected Event");
    }
}
