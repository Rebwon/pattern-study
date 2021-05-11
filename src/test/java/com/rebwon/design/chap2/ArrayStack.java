package com.rebwon.design.chap2;

public final class ArrayStack {
    private int top;
    private final int[] array;
    private final int stackSize;

    public ArrayStack(int stackSize) {
        this.top = -1;
        this.array = new int[stackSize];
        this.stackSize = stackSize;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFill() {
        return (top == this.stackSize -1);
    }

    public void push(int i) {
        if(isFill())
            throw new IllegalStateException("스택이 꽉 찼습니다.");
        array[++top] = i;
    }

    public int pop() {
        if(isEmpty())
            throw new IllegalStateException("스택이 비어있습니다.");
        return array[top--];
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException("스택이 비어있습니다.");
        return array[top];
    }

}
