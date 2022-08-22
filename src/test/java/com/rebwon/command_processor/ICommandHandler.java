package com.rebwon.command_processor;

public interface ICommandHandler<T extends ICommand, R> {

    R handle(T command);
}
