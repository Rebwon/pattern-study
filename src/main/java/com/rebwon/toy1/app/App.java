package com.rebwon.toy1.app;

import com.rebwon.toy1.model.Game;
import com.rebwon.toy1.model.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game(new RandomPositiveNumberGenerator().generateNumber());
        while(true) {
            Output.prepareMode();
            int selectNumber = Integer.parseInt(sc.nextLine());
            if(selectNumber == 3) {
                Output.exit();
                return;
            } else if(selectNumber == 1) {
                Output.singleMode();
                Player player = new Player(UUID.randomUUID().toString());
                while(!game.isCompleted()) {
                    Output.inputNumber();
                    game.start(player.input(Integer.parseInt(sc.nextLine())));
                }
                Output.resultSingleMode(game.numberOfAttempt());
            } else if(selectNumber == 2) {
                Output.multiMode();
                List<Player> players = Arrays.stream(sc.nextLine().split(",")).map(Player::new).collect(Collectors.toList());
                while(!game.isCompleted()) {
                    for(Player player : players) {
                        Output.inputNumber(player);
                        game.start(player.input(Integer.parseInt(sc.nextLine())), player);
                        if(game.isCompleted()) {
                            break;
                        }
                    }
                }
                Output.resultMultiMode(game.winner());
            }
        }
    }
}
