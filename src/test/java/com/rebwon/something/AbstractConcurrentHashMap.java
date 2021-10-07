package com.rebwon.something;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractConcurrentHashMap<K, V> implements ConcurrentHashMap<K, V> {

    protected static final int INITIAL_CAPACITY = 100;

    protected List<Entry<K, V>>[] table;

    protected int size = 0;

    @SuppressWarnings("unchecked")
    public AbstractConcurrentHashMap() {
        table = (List<Entry<K,V>>[]) new List[INITIAL_CAPACITY];
        for (int i=0; i<INITIAL_CAPACITY; i++) {
            table[i] = new ArrayList<>();
        }
    }

    protected abstract void acquire(Entry<K, V> entry);

    protected abstract void release(Entry<K, V> entry);

    protected abstract boolean shouldResize();

    protected abstract void resize();

    @Override
    public boolean put(K key, V value) {
        if (key == null) return false;

        var entry = new Entry<>(key, value);
        acquire(entry);
        try {
            var bucketNumber = findBucket(entry);
            var currentPosition = table[bucketNumber].indexOf(entry);
            if (currentPosition == -1) {
                table[bucketNumber].add(entry);
                size++;
            } else {
                table[bucketNumber].add(currentPosition, entry);
            }
        } finally {
            release(entry);
        }

        if (shouldResize()) resize();
        return true;
    }

    @Override
    public V get(K key) {
        if (key == null) return null;

        var entry = new Entry<K, V>(key, null);
        acquire(entry);

        try {
            var bucket = table[findBucket(entry)];
            return bucket.stream()
                .filter(e -> e.equals(entry))
                .findFirst()
                .map(Entry::getValue)
                .orElse(null);
        } finally {
            release(entry);
        }
    }

    @Override
    public boolean remove(K key) {
        if (key == null) return false;

        var entry = new Entry<K, V>(key, null);
        acquire(entry);
        try {
            boolean result = table[findBucket(entry)].remove(entry);
            if (result) size--;

            return result;
        } finally {
            release(entry);
        }
    }

    protected int findBucket(Entry<K, V> entry) {
        return Math.abs(entry.hashCode()) % table.length;
    }

    public static final class Entry<K, V> {

        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
        }
    }
}
