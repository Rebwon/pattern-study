package com.rebwon.design.chap5.practice;

public final class Member {

    private final String name;
    private final int accumulateAmount;

    public Member(String name, int accumulateAmount) {
        this.name = name;
        this.accumulateAmount = accumulateAmount;
    }

    public String getName() {
        return name;
    }

    public int getAccumulateAmount() {
        return accumulateAmount;
    }
}
