package com.rebwon.design.chap3;

public final class FuelTankMonitoring {

    public void checkAndWarn() {

        if(checkFuelTank()) {
            giveWaringSignal();
        }
    }

    private void giveWaringSignal() {

    }

    private boolean checkFuelTank() {
        return false;
    }
}
