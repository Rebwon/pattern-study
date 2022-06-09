package com.rebwon.object.chap2;

public interface DiscountPolicy {

    interface AMOUNT extends DiscountPolicy {}
    interface PERCENT extends DiscountPolicy {}
    interface NONE extends DiscountPolicy {}
    interface COUNT extends DiscountPolicy {}
}
