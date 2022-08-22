package com.rebwon.command_processor.member;

import java.time.LocalDateTime;

public final class User {

    private UserId userId;
    private String email;
    private String password;
    private String username;
    private LocalDateTime createdAt;

    public User(UserId userId, String email, String password, String username,
        LocalDateTime createdAt) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.username = username;
        this.createdAt = createdAt;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
