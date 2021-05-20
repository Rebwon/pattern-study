package com.rebwon.design.chap7.book;

public final class MoneyBox {
    private int money = 0;

    public int getMoney() {
        return money;
    }

    public void insert(int money) {
        this.money += money;
    }

    public void dispense(int money) {
        this.money -= money;
    }

    public int returnMoney() {
        int temp = this.money;
        this.money = 0;
        return temp;
    }
}
