package com.rebwon.toy1.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.rebwon.toy1.model.Game;
import com.rebwon.toy1.model.PositiveNumberGeneratorStub;
import org.junit.jupiter.api.Test;

public class Specs_RandomNumberGame {
    private static final String NEW_LINE = System.lineSeparator();

    @Test
    void sut_is_incompleted_when_it_is_initialized() {
        Game sut = new Game(new PositiveNumberGeneratorStub(50));

        boolean actual = sut.isCompleted();

        assertThat(actual).isFalse();
    }

    @Test
    void sut_correctly_prints_select_mode_message() {
        Game sut = new Game(new PositiveNumberGeneratorStub(50));

        String message = sut.flushOutput();

        assertThat(message).isEqualTo("Selection Mode" + NEW_LINE + "1. Single Player Mode " + NEW_LINE +
            "2. Multi Player Mode " + NEW_LINE + "3. Exit " + NEW_LINE + "Enter selection : ");
    }
}
