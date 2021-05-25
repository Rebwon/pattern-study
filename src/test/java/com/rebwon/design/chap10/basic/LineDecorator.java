package com.rebwon.design.chap10.basic;

public final class LineDecorator extends DisplayDecorator {

    public LineDecorator(Display display) {
        super(display);
    }

    @Override
    public void draw() {
        super.draw();
        drawLine();
    }

    private void drawLine() {
        System.out.println("Line");
    }
}
