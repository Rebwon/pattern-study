package com.rebwon.design.chap2;

public abstract class Pet {

    public abstract void talk();

    public static class Cat extends Pet {

        @Override
        public void talk() {
            System.out.println("야옹");
        }
    }

    public static class Dog extends Pet {

        @Override
        public void talk() {
            System.out.println("멍멍");
        }
    }

    public static class Parrot extends Pet {

        @Override
        public void talk() {
            System.out.println("안녀엉");
        }
    }
}
