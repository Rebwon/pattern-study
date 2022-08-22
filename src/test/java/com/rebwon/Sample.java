package com.rebwon;

public final class Sample {

    private static final Sample INSTANCE;

    static {
        try {
            INSTANCE = new Sample();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Sample() throws Exception {}

    public static Sample getInstance() {
        return INSTANCE;
    }
}
