package com.rebwon.design.chap5;

public abstract class Robot {

    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    public abstract void move();

    public abstract void attack();

    static class Atom extends Robot {

        public Atom(String name) {
            super(name);
        }

        @Override
        public void move() {

        }

        @Override
        public void attack() {

        }
    }

    static class Sunguard extends Robot {

        public Sunguard(String name) {
            super(name);
        }

        @Override
        public void move() {

        }

        @Override
        public void attack() {

        }
    }

    static class TaekwonV extends Robot {

        public TaekwonV(String name) {
            super(name);
        }

        @Override
        public void move() {

        }

        @Override
        public void attack() {

        }
    }
}
