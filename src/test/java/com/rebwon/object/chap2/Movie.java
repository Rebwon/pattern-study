package com.rebwon.object.chap2;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public final class Movie<T extends DiscountPolicy & DiscountCondition> {

    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final Set<T> discountConditions = new HashSet<>();

    public Movie(String title, Duration runningTime, Money fee, T...conditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions.addAll(Set.of(conditions));
    }

    public Money calculateFee(Screening screening, int audienceCount) {
        for (T condition : discountConditions) {
            if (condition.isSatisfiedBy(screening, audienceCount))
                return condition.calculateFee(fee).multi(audienceCount);
        }
        return fee;
    }
}
