package com.rebwon.something;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class Person {

    private final Date birthDate;

    private static Date BOOM_START;
    private static Date BOOM_END;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        if (BOOM_START == null && BOOM_END == null) {
            init();
        }
        return birthDate.compareTo(BOOM_START) >= 0 &&
            birthDate.compareTo(BOOM_END) < 0;
    }

    private void init() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }
}
