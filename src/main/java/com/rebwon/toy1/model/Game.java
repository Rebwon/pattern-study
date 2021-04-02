package com.rebwon.toy1.model;


public final class Game {

    private final PositiveNumber answer;
    private int numberOfAttempt;
    private boolean isCompleted;
    private Player winner;

    public Game(PositiveNumber answer) {
        this.answer = answer;
    }

    public void start(PositiveNumber positiveNumber) {
        start(positiveNumber, null);
    }

    public void start(PositiveNumber number, Player player) {
        if (number.isSmallerThan(answer)) {
            numberOfAttempt++;
            System.out.println("입력한 숫자가 정답보다 작습니다.");
        } else if (number.isGreaterThan(answer)) {
            numberOfAttempt++;
            System.out.println("입력한 숫자가 정답보다 큽니다.");
        } else if (number.equals(answer)) {
            numberOfAttempt++;
            isCompleted = true;
            winner = player;
            System.out.println("입력한 숫자가 정답과 같습니다.");
        }
    }

    public Player winner() {
        return this.winner;
    }

    public int numberOfAttempt() {
        return this.numberOfAttempt;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }
}
