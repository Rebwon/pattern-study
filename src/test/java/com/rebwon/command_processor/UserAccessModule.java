package com.rebwon.command_processor;

import com.rebwon.command_processor.member.ConfirmUserIdCommand;
import com.rebwon.command_processor.member.RegisterNewUserCommand;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public class UserAccessModule implements IUserAccessModule {

    private final MemberCompositionRoot root;

    public UserAccessModule(MemberCompositionRoot root) {
        this.root = root;
    }

    @Override
    @Transactional
    public Object execute(ICommand command) {
        if (command instanceof RegisterNewUserCommand) {
            return root.commandHandler(command).handle(command);
        }
        return null;
    }
}
