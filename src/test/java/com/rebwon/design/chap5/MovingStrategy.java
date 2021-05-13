package com.rebwon.design.chap5;

interface MovingStrategy {

    void move();

    class FlyingStrategy implements MovingStrategy {

        @Override
        public void move() {
            System.out.println("flying");
        }
    }

    class WalkingStrategy implements MovingStrategy {

        @Override
        public void move() {
            System.out.println("walking");
        }
    }
}
