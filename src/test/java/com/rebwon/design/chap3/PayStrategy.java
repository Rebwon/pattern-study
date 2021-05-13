package com.rebwon.design.chap3;

public interface PayStrategy {

    int calculate(int x, int y);

    class SimplePayStrategy implements PayStrategy {

        @Override
        public int calculate(int x, int y) {
            return x * 15 + y * 10;
        }
    }
}
