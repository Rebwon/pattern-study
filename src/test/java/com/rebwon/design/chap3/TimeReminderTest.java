package com.rebwon.design.chap3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeReminderTest {

    @Test
    void name() {
        TimeReminder reminder = new TimeReminder();
        reminder.reminder();
    }
}