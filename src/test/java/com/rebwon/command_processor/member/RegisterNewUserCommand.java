package com.rebwon.command_processor.member;

import com.rebwon.command_processor.ICommand;

public record RegisterNewUserCommand(
    String email,
    String username,
    String password
)
    implements ICommand {

}
