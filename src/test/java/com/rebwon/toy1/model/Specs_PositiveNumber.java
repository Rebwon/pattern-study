package com.rebwon.toy1.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Specs_PositiveNumber {

    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 101 })
    void sut_positiveNumber_input_wrong_number_throws_exception(int wrongNumber) {
        assertThatThrownBy(
            () -> new PositiveNumber(wrongNumber)
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void sut_compare_positive_number_to_determine_is_greater_than() {
        PositiveNumber expected = new PositiveNumber(71);
        PositiveNumber actual = new PositiveNumber(65);

        assertThat(expected.isGreaterThan(actual)).isTrue();
    }

    @Test
    void sut_compare_positive_number_to_determine_is_smaller_than() {
        PositiveNumber expected = new PositiveNumber(41);
        PositiveNumber actual = new PositiveNumber(65);

        assertThat(expected.isSmallerThan(actual)).isTrue();
    }

    @Test
    void sut_compare_positive_number_to_determine_is_equality() {
        PositiveNumber expected = new PositiveNumber(41);
        PositiveNumber actual = new PositiveNumber(41);

        assertThat(expected.equals(actual)).isTrue();
    }
}
