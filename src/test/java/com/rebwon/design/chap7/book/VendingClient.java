package com.rebwon.design.chap7.book;

public final class VendingClient {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(5, 1000);
        machine.insertMoney(500);
        machine.insertMoney(500);
        machine.pushButton();
    }
}
