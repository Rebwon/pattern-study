package com.rebwon.design.chap2;

import java.util.Vector;

public final class Stack {
    private Vector<Integer> vector = new Vector<>();

    boolean isEmpty() {
        return vector.isEmpty();
    }

    public void push(int item) {
        vector.add(item);
    }

    public int pop() {
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");
        return vector.remove(vector.size() -1);
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");
        return vector.get(vector.size() -1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
