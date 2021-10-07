package com.rebwon.something;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class LockStripedConcurrentHashMap<K, V> extends AbstractConcurrentHashMap<K, V> {

    private final ReentrantLock[] locks;

    public LockStripedConcurrentHashMap() {
        super();
        locks = new ReentrantLock[INITIAL_CAPACITY];
        for (int i=0; i<INITIAL_CAPACITY; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    @Override
    protected void acquire(Entry<K, V> entry) {
        lockFor(entry).lock();
    }

    @Override
    protected void release(Entry<K, V> entry) {
        lockFor(entry).unlock();
    }

    @Override
    protected boolean shouldResize() {
        return size / table.length >= 5;
    }

    @SuppressWarnings({"unchecked", "DuplicatedCode"})
    @Override
    protected void resize() {
        acquireAll();
        try {
            var oldTable     = table;
            var doubleCapacity = oldTable.length * 2;

            table = (List<Entry<K, V>>[]) new List[doubleCapacity];
            for (var i=0; i<doubleCapacity; i++) {
                table[i] = new ArrayList<>();
            }

            for (var entries : oldTable) {
                for (var entry : entries) {
                    var newBucketNumber = Math.abs(entry.hashCode()) % doubleCapacity;
                    table[newBucketNumber].add(entry);
                }
            }
        } finally {
            releaseAll();
        }
    }

    private ReentrantLock lockFor(Entry<K, V> entry) {
        return locks[Math.abs(entry.hashCode()) % locks.length];
    }

    private void acquireAll() {
        for (ReentrantLock lock : locks) {
            lock.lock();
        }
    }

    private void releaseAll() {
        for (ReentrantLock lock : locks) {
            lock.unlock();
        }
    }
}
