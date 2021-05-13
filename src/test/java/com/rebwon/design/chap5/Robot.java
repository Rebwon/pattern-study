package com.rebwon.design.chap5;

public abstract class Robot {

    private final String name;
    private MovingStrategy movingStrategy;
    private AttackStrategy attackStrategy;

    public Robot(String name) {
        this.name = name;
    }

    public void move() {
        movingStrategy.move();
    }

    public void attack() {
        attackStrategy.attack();
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    static class Atom extends Robot {

        public Atom(String name) {
            super(name);
        }
    }

    static class Sunguard extends Robot {

        public Sunguard(String name) {
            super(name);
        }
    }

    static class TaekwonV extends Robot {

        public TaekwonV(String name) {
            super(name);
        }
    }
}
