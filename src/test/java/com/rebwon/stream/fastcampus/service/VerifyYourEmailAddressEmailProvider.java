package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider {

    @Override
    public String getEmail(User user) {
        return "'Verify Your Email Address' email for " + user.getName();
    }

}
