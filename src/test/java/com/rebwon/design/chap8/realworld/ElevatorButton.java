package com.rebwon.design.chap8.realworld;

public final class ElevatorButton {

    private Command command;

    public ElevatorButton(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}
