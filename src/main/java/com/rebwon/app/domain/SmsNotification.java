package com.rebwon.app.domain;

public final class SmsNotification extends Notification {

    public SmsNotification(String content, String receiver) {
        super(null, content, receiver);
    }

    @Override
    public void send() {

    }
}
