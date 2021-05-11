package com.rebwon.design.chap1;

public final class Account {

    private Integer id;
    private String owner;
    private double balance;

    public Account(Integer id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public void withDrawl(double balance) {
        this.balance -= balance;
    }

    protected double getBalance() {
        return this.balance;
    }
}
