package com.rebwon.toy1.model;

public class PositiveNumberGeneratorStub implements PositiveNumberGenerator {
    private PositiveNumber number;

    public PositiveNumberGeneratorStub(int number) {
        this.number = new PositiveNumber(number);
    }

    @Override
    public PositiveNumber generateNumber() {
        return number;
    }
}
