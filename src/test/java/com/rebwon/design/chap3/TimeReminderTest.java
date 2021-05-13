package com.rebwon.design.chap3;

import com.rebwon.design.chap3.TimeReminder.FakeTimeProvider;
import com.rebwon.design.chap3.TimeReminder.Mp3;
import org.junit.jupiter.api.Test;

class TimeReminderTest {

    @Test
    void name() {
        TimeReminder reminder = new TimeReminder(new Mp3(), new FakeTimeProvider(22));
        reminder.reminder();
    }
}