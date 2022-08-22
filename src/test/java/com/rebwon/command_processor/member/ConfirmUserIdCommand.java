package com.rebwon.command_processor.member;

import com.rebwon.command_processor.ICommand;
import java.util.UUID;

public record ConfirmUserIdCommand(
    UUID id
) implements ICommand {

}
