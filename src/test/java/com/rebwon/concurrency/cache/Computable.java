package com.rebwon.concurrency.cache;

public interface Computable<A, V> {

    V compute(A arg) throws InterruptedException;
}
