package com.rebwon.design.chap2;

import java.util.ArrayList;

public final class MyStack  {
    private final ArrayList<String> arrayList = new ArrayList<>();

    public void push(String e) {
        arrayList.add(e);
    }

    public String pop() {
        return arrayList.remove(arrayList.size() -1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int size() {
        return arrayList.size();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("apple");
        stack.push("orange");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
