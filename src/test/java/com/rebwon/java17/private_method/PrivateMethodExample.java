package com.rebwon.java17.private_method;

public final class PrivateMethodExample {

    interface Client {

        void exchange();

        default void get() {
            logging1();
            exchange();
            logging2();
        }

        private void logging1() {
            System.out.println("logging1");
        }

        private static void logging2() {
            System.out.println("logging2");
        }
    }

    public static void main(String[] args) {
        Client client = () -> System.out.println("exchange");
        client.get();
    }
}
