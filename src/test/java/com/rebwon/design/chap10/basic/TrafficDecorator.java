package com.rebwon.design.chap10.basic;

public final class TrafficDecorator extends DisplayDecorator {

    public TrafficDecorator(Display display) {
        super(display);
    }

    @Override
    public void draw() {
        super.draw();
        drawTraffic();
    }

    private void drawTraffic() {
        System.out.println("Traffic");
    }
}
