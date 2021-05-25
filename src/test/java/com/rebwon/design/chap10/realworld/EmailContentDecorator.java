package com.rebwon.design.chap10.realworld;

public abstract class EmailContentDecorator implements EmailContent {

    private EmailContent emailContent;

    public EmailContentDecorator(EmailContent emailContent) {
        this.emailContent = emailContent;
    }

    @Override
    public String getContent() {
        return emailContent.getContent();
    }
}
