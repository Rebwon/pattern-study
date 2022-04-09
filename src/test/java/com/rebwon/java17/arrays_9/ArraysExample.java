package com.rebwon.java17.arrays_9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public final class ArraysExample {

    @Test
    void arrays_compare1() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        int result = Arrays.compare(a, b);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void arrays_compare2() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3, 4};

        int result = Arrays.compare(a, b);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void arrays_compare3() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3};

        int result = Arrays.compare(a, b);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void arrays_mismatch1() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3, 4};

        int result = Arrays.mismatch(a, b);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void arrays_mismatch2() {
        int[] a = {1, 4, 3};
        int[] b = {1, 2, 3};

        int result = Arrays.mismatch(a, b);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void arrays_mismatch3() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        int result = Arrays.mismatch(a, b);

        assertThat(result).isEqualTo(-1);
    }
}
