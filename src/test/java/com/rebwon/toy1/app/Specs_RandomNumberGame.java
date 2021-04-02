package com.rebwon.toy1.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.rebwon.toy1.model.Game;
import com.rebwon.toy1.model.Player;
import com.rebwon.toy1.model.PositiveNumber;
import org.junit.jupiter.api.Test;

public class Specs_RandomNumberGame {

    // Game 게임의 라이프사이클을 관리하는 역할
    // Player 숫자를 입력하는 역할
    // Number 숫자를 담당하는 역할

    @Test
    void sut_player_input_correct_number_return_positiveNumber() {
        Player player = new Player("kitty");

        PositiveNumber number = player.input(50);

        assertThat(number).isNotNull();
    }

    @Test
    void sut_player_input_number_is_smaller_than_answer() {
        Game game = new Game(new PositiveNumber(65));
        Player player = new Player("kitty");

        game.start(player.input(50));
    }

    @Test
    void sut_player_input_number_is_greater_than_answer() {
        Game game = new Game(new PositiveNumber(45));
        Player player = new Player("kitty");

        game.start(player.input(50));
    }

    @Test
    void sut_single_player_mode_game_round_ended_return_attempted_number() {
        Game game = new Game(new PositiveNumber(50));
        Player player = new Player("kitty");

        for(int i=1; i<=5; i++) {
            game.start(player.input(i));
        }

        game.start(player.input(50));
        int attemptedNumber = game.numberOfAttempt();

        assertThat(game.isCompleted()).isTrue();
        assertThat(attemptedNumber).isEqualTo(6);
    }

    @Test
    void 멀티모드_게임_지원_여러_명의_플레이어를_넣는다_플레이어_이름은_중복되면_안된다() {
        Game game = new Game(new PositiveNumber(40));

    }

}
