package com.rebwon.object.chap2;

import com.rebwon.object.chap2.DiscountPolicy.PERCENT;

public abstract class PercentDiscount implements PERCENT, DiscountCondition {

    private final double percent;

    protected PercentDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(fee.multi(percent));
    }
}
