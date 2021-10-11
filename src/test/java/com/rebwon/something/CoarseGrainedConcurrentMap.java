package com.rebwon.something;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class CoarseGrainedConcurrentMap<K, V> extends AbstractConcurrentHashMap<K, V> {

    private final ReentrantLock lock;

    public CoarseGrainedConcurrentMap() {
        super();
        this.lock = new ReentrantLock();
    }

    @Override
    protected void acquire(Entry<K, V> entry) {
        lock.lock();
    }

    @Override
    protected void release(Entry<K, V> entry) {
        lock.unlock();
    }

    @Override
    protected boolean shouldResize() {
        return size / table.length >= 5;
    }

    @Override
    @SuppressWarnings({"unchecked", "DuplicatedCode"})
    protected void resize() {
        lock.lock();
        try {
            var oldTable = table;
            var doubledCapacity = oldTable.length * 2;

            table = (List<Entry<K, V>>[]) new List[doubledCapacity];
            for (var i = 0; i < doubledCapacity; i++) {
                table[i] = new ArrayList<>();
            }

            for (var entries : oldTable) {
                for (var entry : entries) {
                    var newBucketNumber = Math.abs(entry.hashCode()) % doubledCapacity;
                    table[newBucketNumber].add(entry);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
