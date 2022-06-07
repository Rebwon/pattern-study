package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.User;

public interface EmailProvider {

    String getEmail(User user);
}
