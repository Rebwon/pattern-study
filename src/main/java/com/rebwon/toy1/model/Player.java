package com.rebwon.toy1.model;

import java.util.Objects;

public final class Player {

    private final String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public PositiveNumber input(int number) {
        return new PositiveNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    public String getName() {
        return this.playerName;
    }
}
