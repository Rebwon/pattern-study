package com.rebwon.object.chap2;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening, int audienceCount);

    Money calculateFee(Money fee);
}
