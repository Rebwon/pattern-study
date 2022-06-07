package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.User;

public final class EmailSender {

    private EmailProvider emailProvider;

    public EmailSender setEmailProvider(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
        return this;
    }

    public void sendEmail(User user) {
        String email = emailProvider.getEmail(user);
        System.out.println("Sending " + email);
    }
}
