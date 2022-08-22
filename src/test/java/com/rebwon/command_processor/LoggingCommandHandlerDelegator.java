package com.rebwon.command_processor;

public final class LoggingCommandHandlerDelegator implements ICommandHandler {

    private final ICommandHandler commandHandler;

    public LoggingCommandHandlerDelegator(ICommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public Object handle(ICommand command) {
        System.out.println("Some logging: " + command);
        Object result = commandHandler.handle(command);
        System.out.println("After logging: " + command);
        return result;
    }
}
