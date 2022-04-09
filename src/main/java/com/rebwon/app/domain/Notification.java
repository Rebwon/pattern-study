package com.rebwon.app.domain;

public abstract sealed class Notification permits EmailNotification, SmsNotification{

    private String title;
    private String content;
    private String receiver;

    public Notification(String title, String content, String receiver) {
        this.title = title;
        this.content = content;
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getReceiver() {
        return receiver;
    }

    public abstract void send();
}

