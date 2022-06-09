package com.rebwon.object.chap2;

public final class Money {

    private final Double amount;

    private Money(Double amount) {
        this.amount = amount;
    }

    public static Money of(double amount) {
        return new Money(amount);
    }

    public Money multi(double times) {
        return new Money(this.amount * times);
    }

    public Money minus(Money other) {
        return new Money(this.amount > other.amount ? this.amount - other.amount : 0.0);
    }

    public Money plus(Money amount) {
        return new Money(this.amount + amount.amount);
    }
}
