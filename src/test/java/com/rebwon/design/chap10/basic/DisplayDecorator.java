package com.rebwon.design.chap10.basic;

public abstract class DisplayDecorator implements Display {

    private Display display;

    public DisplayDecorator(Display display) {
        this.display = display;
    }

    @Override
    public void draw() {
        display.draw();
    }
}
