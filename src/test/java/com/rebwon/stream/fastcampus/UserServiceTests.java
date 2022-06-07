package com.rebwon.stream.fastcampus;

import com.rebwon.stream.fastcampus.model.User;
import com.rebwon.stream.fastcampus.service.InternalUserService;
import com.rebwon.stream.fastcampus.service.UserService;
import java.util.Arrays;

public final class UserServiceTests {

    public static void main(String[] args) {
        User alice = User.builder(1, "Alice")
            .with(builder -> {
                builder.emailAddress = "alice@fastcampus.co.kr";
                builder.isVerified = false;
                builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
            }).build();

        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();

        userService.createUser(alice);
        internalUserService.createUser(alice);

        UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
            user -> {
                System.out.println("Validating user " + user.getName());
                return user.getName() != null && user.getEmailAddress().isPresent();
            },
            user -> System.out.println("Writing user " + user.getName() + " to DB"));
        userServiceInFunctionalWay.createUser(alice);
    }
}
