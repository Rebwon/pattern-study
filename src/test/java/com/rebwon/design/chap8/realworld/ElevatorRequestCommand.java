package com.rebwon.design.chap8.realworld;

public final class ElevatorRequestCommand implements Command {

    private int destination;
    private Direction direction;
    private ElevatorManager manager;

    public ElevatorRequestCommand(int destination, Direction direction, ElevatorManager manager) {
        this.destination = destination;
        this.direction = direction;
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.requestElevator(destination, direction);
    }
}
