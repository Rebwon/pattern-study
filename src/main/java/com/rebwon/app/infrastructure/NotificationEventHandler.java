package com.rebwon.app.infrastructure;

import com.rebwon.app.domain.DomainEvent;
import com.rebwon.app.domain.Notification;
import com.rebwon.app.domain.NotificationModule.MemberRegistered;
import com.rebwon.app.domain.NotificationModule.OrderCreated;
import com.rebwon.app.domain.NotificationModule.OrderCreatedNotificationHandler;
import com.rebwon.app.domain.NotificationModule.PaymentCompleted;
import com.rebwon.app.domain.NotificationModule.PaymentCompletedNotificationHandler;
import com.rebwon.app.domain.NotificationModule.RegisteredNotificationHandler;
import com.rebwon.app.domain.NotificationRepository;

public record NotificationEventHandler(NotificationRepository repository) implements EventHandler {

    @Override
    public void handle(DomainEvent event) {
        Notification notification = handleInternal(event);
        repository.save(notification);
    }

    private Notification handleInternal(DomainEvent event) {
        if (event instanceof MemberRegistered) {
            return new RegisteredNotificationHandler().handle((MemberRegistered) event);
        }
        return null;
    }
}
