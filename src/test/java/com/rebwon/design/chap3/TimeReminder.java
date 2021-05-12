package com.rebwon.design.chap3;

import java.util.Calendar;

public final class TimeReminder {
    private Mp3 m;

    public void reminder() {
        Calendar calendar = Calendar.getInstance();
        m = new Mp3();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if(hour >= 22)
            m.playSong();
    }

    public static class Mp3 {

        public void playSong() {
            System.out.println("Playing");
        }
    }
}
