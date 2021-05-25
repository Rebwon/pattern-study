package com.rebwon.design.chap10.realworld;

public final class SecureEmailContent extends EmailContentDecorator {

    public SecureEmailContent(EmailContent emailContent) {
        super(emailContent);
    }

    @Override
    public String getContent() {
        return encrypt(super.getContent());
    }

    private String encrypt(String content) {
        return content + " Encrypted";
    }
}
