package com.rebwon.design.chap2.practice;

public abstract class DiscountMode {

    public abstract double calculate(double price);

    public static class OnSale extends DiscountMode {

        @Override
        public double calculate(double price) {
            return price - 0.1 * price;
        }
    }

    public static class TodayEvent extends DiscountMode {

        @Override
        public double calculate(double price) {
            return price - 0.3 * price;
        }
    }

    public static class None extends DiscountMode {

        @Override
        public double calculate(double price) {
            return price;
        }
    }
}
