package com.rebwon.design.chap2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class ArrayStackTest {

    @Test
    void pushAndPop() {
        ArrayStack stack = new ArrayStack(2);
        stack.push(3);
        stack.push(4);

        assertThat(stack.pop()).isEqualTo(4);
    }

    @Test
    void peek() {
        ArrayStack stack = new ArrayStack(2);
        stack.push(3);
        stack.push(4);

        assertThat(stack.peek()).isEqualTo(4);
    }
}
