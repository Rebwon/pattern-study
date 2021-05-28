package com.rebwon.design.chap11.basic;

import com.rebwon.design.chap8.realworld.Direction;

public interface ElevatorScheduler {

    int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction);
}
