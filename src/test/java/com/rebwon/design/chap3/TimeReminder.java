package com.rebwon.design.chap3;

import java.util.Calendar;

public final class TimeReminder {
    private final Mp3 m;
    private final TimeProvider provider;

    public TimeReminder(Mp3 m, TimeProvider provider) {
        this.m = m;
        this.provider = provider;
    }

    public void reminder() {
        int hour = provider.getTime();
        if(hour >= 22)
            m.playSong();
    }

    public static class Mp3 {

        public void playSong() {
            System.out.println("Playing");
        }
    }

    interface TimeProvider {
        void setHours(int hours);
        int getTime();
    }

    public static class FakeTimeProvider implements TimeProvider {
        private Calendar cal;

        public FakeTimeProvider() {
            this.cal = Calendar.getInstance();
        }

        public FakeTimeProvider(int hours) {
            this.cal = Calendar.getInstance();
            setHours(hours);
        }

        @Override
        public void setHours(int hours) {
            cal.set(Calendar.HOUR_OF_DAY, hours);
        }

        @Override
        public int getTime() {
            return cal.get(Calendar.HOUR_OF_DAY);
        }
    }
}
