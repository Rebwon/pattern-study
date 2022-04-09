package com.rebwon.app.domain;

public final class EmailNotification extends Notification {

    public EmailNotification(String title, String content, String receiver) {
        super(title, content, receiver);
    }

    @Override
    public void send() {

    }
}
