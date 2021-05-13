package com.rebwon.design.chap3;

public final class Employee {

    private String id;
    private String name;
    private int workHours;
    private int overTimeHours;
    private PayProcessor processor;

    public int calculatePay() {
        return processor.calculatePay(this);
    }

    public void setProcessor(PayProcessor processor) {
        this.processor = processor;
    }

    interface PayProcessor {
        int calculatePay(Employee employee);
    }
}
