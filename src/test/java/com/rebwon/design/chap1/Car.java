package com.rebwon.design.chap1;

import java.util.List;

public final class Car {
    private Gas gas;
    private Integer amount;

    public void fillGas(GasPump pump) {
        this.gas = pump.getGas(amount);
    }

    public static class Gas {

    }

    public static class GasPump {
        private Integer amount;
        private Integer savedAmount;
        private List<Gas> gases;

        public Gas getGas(Integer amount) {
            if(this.amount.equals(amount)) {
                savedAmount += amount;
                return gases.stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("가스가 고갈되었습니다."));
            }
            throw new IllegalArgumentException("가스를 구매할 돈이 부족합니다.");
        }
    }
}
