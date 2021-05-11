package com.rebwon.design.chap2;

import java.util.ArrayList;

public final class MyStack extends ArrayList<String> {

    public MyStack(int initialCapacity) {
        super(initialCapacity);
    }

    public void push(String e) {
        add(e);
    }

    public String pop() {
        return remove(size() -1);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(2);
        stack.push("apple");
        stack.push("orange");
        stack.set(0, "pineapple");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
