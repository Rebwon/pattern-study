package com.rebwon.design.chap5;

interface AttackStrategy {

    void attack();

    class PunchStrategy implements AttackStrategy {

        @Override
        public void attack() {
            System.out.println("punch");
        }
    }

    class MissileStrategy implements AttackStrategy {

        @Override
        public void attack() {
            System.out.println("missile");
        }
    }
}
