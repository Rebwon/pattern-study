package com.rebwon.vanilladi;

public class FooStub extends Foo {

    private int nextValue;

    public FooStub(int nextValue) {
        this.nextValue = nextValue;
    }

    @Override
    public int getSomething() {
        return nextValue;
    }
}
