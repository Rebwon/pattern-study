package com.rebwon.something;

import java.util.Map;

public final class BasicConcurrentHashMap {

    private Map<String, String> data;
    private Object[] locks = new Object[16];

    public BasicConcurrentHashMap(Map<String, String> data) {
        this.data = data;
    }

    public void putIfAbsent(String key, String value) {
        Integer idx = key.hashCode() % 16;

        synchronized (idx) {
            if (data.get(key) == null) {
                data.put(key, value);
            }
        }
    }
}
