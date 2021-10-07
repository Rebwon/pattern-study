package com.rebwon.something;

public interface ConcurrentHashMap<K, V> {

    boolean put(K key, V value);

    V get(K key);

    boolean remove(K key);
}
