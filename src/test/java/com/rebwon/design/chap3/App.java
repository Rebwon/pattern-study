package com.rebwon.design.chap3;

import com.rebwon.design.chap3.PayStrategy.SimplePayStrategy;

public final class App {

    public static void main(String[] args) {
        PayGUI machine = new PayGUI(new SimplePayStrategy());
    }
}
