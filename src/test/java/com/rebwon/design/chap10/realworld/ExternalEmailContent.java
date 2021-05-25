package com.rebwon.design.chap10.realworld;

public final class ExternalEmailContent extends EmailContentDecorator {

    public ExternalEmailContent(EmailContent emailContent) {
        super(emailContent);
    }

    @Override
    public String getContent() {
        return addDisclaimer(super.getContent());
    }

    private String addDisclaimer(String content) {
        return content + " Company Disclaimer";
    }
}
