package com.rebwon.design.chap2;

public abstract class Role {

    public abstract void work();

    public static class Driver extends Role {

        @Override
        public void work() {
            System.out.println("Driving");
        }
    }

    public static class Worker extends Role {

        @Override
        public void work() {
            System.out.println("Working");
        }
    }
}
