package com.rebwon.command_processor.member;

public interface UserRepository {

    User save(User entity);

    User findByUserId(UserId userId);
}
