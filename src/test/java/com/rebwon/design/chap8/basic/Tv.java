package com.rebwon.design.chap8.basic;

public final class Tv {

    private boolean powerOn;
    private boolean muteOn;

    public void mute() {
        if(!powerOn)
            return;
        muteOn =! powerOn;

        if (muteOn)
            System.out.println("Mute on");
        else
            System.out.println("Mute off");
    }

    public void power() {
        powerOn =! powerOn;

        if (powerOn)
            System.out.println("Power on");
        else
            System.out.println("Power off");
    }
}
