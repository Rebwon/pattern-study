package com.rebwon.command_processor;

import com.rebwon.command_processor.ICommandHandler;
import com.rebwon.command_processor.member.ConfirmUserCommandHandler;
import com.rebwon.command_processor.member.ConfirmUserIdCommand;
import com.rebwon.command_processor.member.PasswordEncrypter;
import com.rebwon.command_processor.member.RegisterNewUserCommand;
import com.rebwon.command_processor.member.RegisterNewUserCommandHandler;
import com.rebwon.command_processor.member.UserRepository;
import com.rebwon.command_processor.member.impl.InMemoryUserRepository;
import com.rebwon.command_processor.member.impl.PasswordEncrypterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MemberCompositionRoot {

    public PasswordEncrypter passwordEncrypter() {
        return new PasswordEncrypterImpl();
    }

    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    public ICommandHandler commandHandler(ICommand command) {
        return commandHandlers().get(command.getClass());
    }

    private Map<Class<? extends ICommand>, ICommandHandler> commandHandlers() {
        Map<Class<? extends ICommand>, ICommandHandler> map = new HashMap<>();
        map.put(RegisterNewUserCommand.class, new RegisterNewUserCommandHandler(userRepository(), passwordEncrypter()));
        map.put(ConfirmUserIdCommand.class, new ConfirmUserCommandHandler(userRepository()));
        return map;
    }
}
