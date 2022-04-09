package com.rebwon.app.domain;

public final class NotificationModule {

    public static class MemberRegistered implements DomainEvent {

    }

    public static class OrderCreated implements DomainEvent {

    }

    public static class PaymentCompleted implements DomainEvent {

    }

    public interface ExternalEventNotificationHandler<T extends DomainEvent> {

        Notification handle(T event);
    }

    public static class RegisteredNotificationHandler
        implements ExternalEventNotificationHandler<MemberRegistered> {

        @Override
        public Notification handle(MemberRegistered event) {
            System.out.println("알림: 가입됨");
            return new EmailNotification("가입됨", "가입됨", "가입됨");
        }
    }

    public static class OrderCreatedNotificationHandler
        implements ExternalEventNotificationHandler<OrderCreated> {

        @Override
        public Notification handle(OrderCreated event) {
            System.out.println("알림: 주문됨");
            return new SmsNotification("주문됨", "주문됨");
        }
    }

    public static class PaymentCompletedNotificationHandler
        implements ExternalEventNotificationHandler<PaymentCompleted> {

        @Override
        public Notification handle(PaymentCompleted event) {
            System.out.println("알림: 결제됨");
            return new EmailNotification("결제됨", "결제됨", "결제됨");
        }
    }
}
