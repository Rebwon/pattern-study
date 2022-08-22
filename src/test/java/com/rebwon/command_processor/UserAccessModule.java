package com.rebwon.command_processor;

import com.rebwon.command_processor.member.ConfirmUserIdCommand;
import com.rebwon.command_processor.member.RegisterNewUserCommand;
import java.util.List;

public final class UserAccessModule implements IUserAccessModule {

    private final MemberCompositionRoot root;

    public UserAccessModule(MemberCompositionRoot root) {
        this.root = root;
    }

    @Override
    public Object execute(ICommand command) {
        return switch (command) {
            case RegisterNewUserCommand c -> root.commandHandler(c).handle(c);
            case ConfirmUserIdCommand c -> root.commandHandler(c).handle(c);
            default -> throw new IllegalStateException("Not found command handler");
        };
    }
}
