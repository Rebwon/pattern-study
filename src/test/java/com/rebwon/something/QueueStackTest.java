package com.rebwon.something;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public final class QueueStackTest {

    @Test
    void reverseQueue() {
        Queue<Integer> intQueue = new ArrayDeque<>();
        for (int i = 1; i < 6; i++) {
            intQueue.add(i);
        }

        System.out.println(intQueue);

        Stack<Integer> intStack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            intStack.push(intQueue.poll());
        }

        System.out.println(intStack);

        Queue<Integer> intQueue2 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            intQueue2.add(intStack.pop());
        }

        System.out.println(intQueue2);
    }
}
