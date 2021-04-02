package com.rebwon.toy1.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Specs_PositiveNumberGenerator {

    @Test
    void sut_random_generator_return_positiveNumber() {
        PositiveNumberGenerator generator = new TestRandomPositiveNumberGenerator();

        assertThat(generator.generateNumber()).isEqualTo(new PositiveNumber(50));
    }

    static class TestRandomPositiveNumberGenerator implements PositiveNumberGenerator {
        @Override
        public PositiveNumber generateNumber() {
            return new PositiveNumber(50);
        }
    }
}
