package com.rebwon.app.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.rebwon.app.domain.Notification;
import com.rebwon.app.domain.NotificationModule.MemberRegistered;
import com.rebwon.app.domain.NotificationRepository;
import org.junit.jupiter.api.Test;

public final class NotificationEventHandlerTest {

    @Test
    void name() {
        // Arrange
        var eventHandler = new NotificationEventHandler(new NotificationRepositoryStub());

        // Act
        Throwable result = catchThrowable(() -> eventHandler.handle(new MemberRegistered()));

        // Assert
        assertThat(result).isNull();
    }

    static class NotificationRepositoryStub implements NotificationRepository {

        @Override
        public Notification save(Notification entity) {
            return null;
        }
    }
}
