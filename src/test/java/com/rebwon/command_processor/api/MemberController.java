package com.rebwon.command_processor.api;

import com.rebwon.command_processor.IUserAccessModule;
import com.rebwon.command_processor.member.RegisterNewUserCommand;
import com.rebwon.command_processor.member.UserId;
import org.springframework.http.ResponseEntity;

public final class MemberController {

    private final IUserAccessModule userAccessModule;

    public MemberController(IUserAccessModule userAccessModule) {
        this.userAccessModule = userAccessModule;
    }

    // POST /users
    public ResponseEntity<?> register(String email, String password, String username) {
        return ResponseEntity.ok(
            userAccessModule.execute(new RegisterNewUserCommand(email, username, password))
        );
    }
}
