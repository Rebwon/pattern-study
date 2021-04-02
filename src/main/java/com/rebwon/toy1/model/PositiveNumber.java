package com.rebwon.toy1.model;

import java.util.Objects;

public final class PositiveNumber {

    private final int number;

    public PositiveNumber(int number) {
        verifyNumber(number);
        this.number = number;
    }

    private void verifyNumber(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalStateException();
        }
    }

    public boolean isGreaterThan(PositiveNumber compareNumber) {
        return this.number > compareNumber.number;
    }

    public boolean isSmallerThan(PositiveNumber compareNumber) {
        return this.number < compareNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber number1 = (PositiveNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
