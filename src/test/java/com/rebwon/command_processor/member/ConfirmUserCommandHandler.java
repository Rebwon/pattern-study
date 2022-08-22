package com.rebwon.command_processor.member;

import com.rebwon.command_processor.ICommandHandler;

public final class ConfirmUserCommandHandler implements ICommandHandler<ConfirmUserIdCommand, Void> {

    private final UserRepository userRepository;

    public ConfirmUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Void handle(ConfirmUserIdCommand command) {
        User user = userRepository.findByUserId(new UserId(command.id()));
        if (user == null) {
            throw new IllegalStateException("User has not found!");
        }
        return null;
    }
}
