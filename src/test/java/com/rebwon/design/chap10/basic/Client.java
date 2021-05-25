package com.rebwon.design.chap10.basic;

public final class Client {

    public static void main(String[] args) {
        Display display = new TrafficDecorator(new LineDecorator(new RoadDisplay()));
        display.draw();

        Display roadWithLine = new LineDecorator(new RoadDisplay());
        roadWithLine.draw();
    }
}
