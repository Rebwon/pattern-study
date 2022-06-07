package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.User;

public abstract class AbstractUserService {

    protected abstract boolean validateUser(User user);

    protected abstract void writeToDatabase(User user);

    public void createUser(User user) {
        if (validateUser(user)) {
            writeToDatabase(user);
        } else {
            System.out.println("Cannot create user");
        }
    }
}

