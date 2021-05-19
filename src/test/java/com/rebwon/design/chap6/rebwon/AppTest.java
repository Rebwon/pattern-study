package com.rebwon.design.chap6.rebwon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class AppTest {

    @Test
    void name() {
        // Arrange
        TicketPublisher publisher = TicketPublisher.getInstance();
        User user = new User("kim");

        // Act
        user.publishTicket(publisher);

        // Assert
        assertThat(user.hasTicket()).isTrue();
    }
}
