package com.rebwon.object.chap2;

import com.rebwon.object.chap2.DiscountPolicy.COUNT;

public abstract class CountDiscount implements COUNT, DiscountCondition {

    private final int count;

    public CountDiscount(int count) {
        this.count = count;
    }

    @Override
    public Money calculateFee(Money fee) {
        return fee.multi(count);
    }
}
