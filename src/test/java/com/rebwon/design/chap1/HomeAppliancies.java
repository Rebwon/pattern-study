package com.rebwon.design.chap1;

import java.time.Year;

public abstract class HomeAppliancies {

    private Integer serialNo;
    private String manufacturer;
    private Year year;

    public abstract void turnOn();

    public abstract void turnOff();
}
