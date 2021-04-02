package com.rebwon.toy1.model;


public final class Game {
    private static final String NEW_LINE = System.lineSeparator();

    public Game(PositiveNumberGenerator generator) {

    }

    public String flushOutput() {
        return "Selection Mode" + NEW_LINE + "1. Single Player Mode " + NEW_LINE +
            "2. Multi Player Mode " + NEW_LINE + "3. Exit " + NEW_LINE + "Enter selection : ";
    }

    public boolean isCompleted() {
        return false;
    }
}
