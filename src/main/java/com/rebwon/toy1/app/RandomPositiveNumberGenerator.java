package com.rebwon.toy1.app;

import com.rebwon.toy1.model.PositiveNumber;
import com.rebwon.toy1.model.PositiveNumberGenerator;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomPositiveNumberGenerator implements PositiveNumberGenerator {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public PositiveNumber generateNumber() {
        return new PositiveNumber(RANDOM.nextInt(1, 100));
    }
}
