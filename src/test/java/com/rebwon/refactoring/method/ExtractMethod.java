package com.rebwon.refactoring.method;

import java.util.Enumeration;

public final class ExtractMethod {
    private String _name;
    private Enumeration<Order> _orders;

    void printOwing(double previousAmount) {
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    private double getOutstanding() {
        double result = 0.0;
        Enumeration<Order> e = _orders;
        while (e.hasMoreElements()) {
            Order each = e.nextElement();
            result += each.amount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        System.out.println("name: " + _name);
        System.out.println("amount: " + outstanding);
    }

    private void printBanner() {
        System.out.println("**************************");
        System.out.println("**** Customer Owes ****");
        System.out.println("**************************");
    }

}

record Order(double amount) {

}