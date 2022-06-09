package com.rebwon.object.chap2;

import java.time.Duration;

public final class PeriodCountDiscount extends CountDiscount {

    private final Duration duration;

    public PeriodCountDiscount(int count, Duration duration) {
        super(count);
        this.duration = duration;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return false;
    }
}
