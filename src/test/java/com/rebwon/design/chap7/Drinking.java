package com.rebwon.design.chap7;

public final class Drinking {

    private int stock;
    private int price;

    public Drinking(int stock, int price) {

        this.stock = stock;
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public void dispense() {
        this.stock--;
    }
}
