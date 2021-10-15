package com.rebwon.concurrency;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public final class AtomicVHCounter implements Counter {

    private volatile int value = 0;
    private static final VarHandle vh;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            vh = l.findVarHandle(AtomicVHCounter.class, "value",
                int.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    @Override
    public int increment() {
        int i;
        do {
            i = (int) vh.getVolatile(this);
        } while (!vh.compareAndSet(this, i, i + 1));

        return i;
    }

    @Override
    public int get() {
        return value;
    }
}
