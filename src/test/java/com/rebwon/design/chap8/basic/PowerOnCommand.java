package com.rebwon.design.chap8.basic;

public final class PowerOnCommand implements Command {
    private Tv tv;

    @Override
    public void execute() {
        tv.power();
    }
}
