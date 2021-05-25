package com.rebwon.design.chap8.realworld;

public final class Client {

    public static void main(String[] args) {
        ElevatorController controller1 = new ElevatorController(1);
        ElevatorController controller2 = new ElevatorController(2);

        ElevatorManager manager = new ElevatorManager(2);
        manager.addController(controller1);
        manager.addController(controller2);

        Command destinationSelectionCommand1 =
            new DestinationSelectionCommand(1, controller1);
        ElevatorButton button1 = new ElevatorButton(destinationSelectionCommand1);
        button1.pressed();

        Command destinationSelectionCommand2 =
            new DestinationSelectionCommand(2, controller2);
        ElevatorButton button2 = new ElevatorButton(destinationSelectionCommand2);
        button2.pressed();

        Command elevatorRequestCommand = new ElevatorRequestCommand(2,
            Direction.DOWN, manager);
        ElevatorButton button3 = new ElevatorButton(elevatorRequestCommand);
        button3.pressed();
    }
}
