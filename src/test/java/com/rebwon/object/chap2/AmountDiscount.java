package com.rebwon.object.chap2;

import com.rebwon.object.chap2.DiscountPolicy.AMOUNT;

public abstract class AmountDiscount implements AMOUNT, DiscountCondition {

    private final Money amount;

    protected AmountDiscount(Money amount) {
        this.amount = amount;
    }

    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(this.amount);
    }
}
