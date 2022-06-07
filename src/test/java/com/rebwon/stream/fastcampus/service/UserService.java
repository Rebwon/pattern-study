package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.User;

public class UserService extends AbstractUserService {

    @Override
    protected boolean validateUser(User user) {
        System.out.println("Validating user " + user.getName());
        return user.getName() != null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void writeToDatabase(User user) {
        System.out.println("Writing user " + user.getName() + " to DB");
    }
}
