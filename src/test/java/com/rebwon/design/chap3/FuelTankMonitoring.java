package com.rebwon.design.chap3;

public final class FuelTankMonitoring {
    // 1번 FuelTank를 만들어서, 위임
    // 2번 FuelTank를 만들어서 연료 검사하고, 발송은 다른 방식.
    private WaringSignal signal;
    private FuelTank fuelTank;

    public void checkAndWarn() {

        if(fuelTank.checkFuelTank()) {  // 연료를 검사하는 기능
            signal.send();          // 에러를 발송하는 기능
        }
    }

    interface WaringSignal {
        void send();
    }

    public static class FuelTank {

        public boolean checkFuelTank() {
            return true;
        }
    }
}
