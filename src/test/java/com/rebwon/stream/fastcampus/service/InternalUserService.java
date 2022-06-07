package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.User;

public class InternalUserService extends AbstractUserService {

    @Override
    protected boolean validateUser(User user) {
        System.out.println("validating internal user " + user.getName());
        return true;
    }

    @Override
    protected void writeToDatabase(User user) {
        System.out.println("Writing user " + user.getName() + " to internal DB");
    }
}
