package com.rebwon.command_processor.member.impl;

import com.rebwon.command_processor.member.User;
import com.rebwon.command_processor.member.UserId;
import com.rebwon.command_processor.member.UserRepository;

public final class InMemoryUserRepository implements UserRepository {

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User findByUserId(UserId userId) {
        return null;
    }
}
