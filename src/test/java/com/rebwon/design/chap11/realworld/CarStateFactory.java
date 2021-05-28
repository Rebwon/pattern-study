package com.rebwon.design.chap11.realworld;

public final class CarStateFactory {

    public enum CarStateID { NORMAL, LIMP_MODE }

    private CarStateFactory() {}

    public static CarState getState(CarStateID id, Car car) {
        CarState state = null;
        switch (id) {
            case NORMAL:
                state = NormalState.getInstance(car);
                break;
            case LIMP_MODE:
                state = LimpState.getInstance(car);
                break;
        }
        return state;
    }
}
