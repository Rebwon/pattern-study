package com.rebwon.concurrency.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    // if 절에 동시 접근 시 2개의 같은 값을 가질 여지가 있음
    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
