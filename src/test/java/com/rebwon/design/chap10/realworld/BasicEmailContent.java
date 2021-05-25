package com.rebwon.design.chap10.realworld;

public final class BasicEmailContent implements EmailContent {

    private String content;

    public BasicEmailContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
