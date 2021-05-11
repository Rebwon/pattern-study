package com.rebwon.design.chap2;

import java.util.ArrayList;

public final class ArrayListStack {
    private final int stackSize;
    private final ArrayList<Integer> items;

    public ArrayListStack(int stackSize) {
        this.items = new ArrayList<>(stackSize);
        this.stackSize = stackSize;
    }

    boolean isEmpty() {
        return items.isEmpty();
    }

    boolean isFill() {
        return (items.size() >= stackSize);
    }

    public void push(int item) {
        if(isFill()) {
            throw new IllegalStateException("스택이 꽉 찼습니다.");
        } else {
            items.add(item);
        }
    }

    public int pop() {
        if(isEmpty())
            throw new IllegalStateException("스택이 비어있습니다.");
        return items.remove(items.size() -1);
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException("스택이 비어있습니다.");
        return items.get(items.size() -1);
    }
}
