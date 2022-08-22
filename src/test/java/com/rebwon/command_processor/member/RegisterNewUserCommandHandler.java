package com.rebwon.command_processor.member;

import com.rebwon.command_processor.ICommandHandler;
import java.time.LocalDateTime;
import java.util.UUID;

public final class RegisterNewUserCommandHandler implements ICommandHandler<RegisterNewUserCommand, UserId> {

    private final UserRepository userRepository;
    private final PasswordEncrypter encrypter;

    public RegisterNewUserCommandHandler(UserRepository userRepository, PasswordEncrypter encrypter) {
        this.userRepository = userRepository;
        this.encrypter = encrypter;
    }

    @Override
    public UserId handle(RegisterNewUserCommand command) {
        User entity = new User(new UserId(UUID.randomUUID()), command.email(),
            encrypter.encrypt(command.password()),
            command.username(), LocalDateTime.now());

        userRepository.save(entity);
        return entity.getUserId();
    }
}
