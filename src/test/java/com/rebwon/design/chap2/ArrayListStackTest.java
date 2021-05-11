package com.rebwon.design.chap2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ArrayListStackTest {

    @Test
    void pushAndPop() {
        ArrayListStack stack = new ArrayListStack(2);
        stack.push(3);
        stack.push(4);

        assertThat(stack.pop()).isEqualTo(4);
    }

    @Test
    void peek() {
        ArrayListStack stack = new ArrayListStack(2);
        stack.push(3);
        stack.push(4);

        assertThat(stack.peek()).isEqualTo(4);
    }
}