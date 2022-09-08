package com.rebwon.event_sourcing;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public final class EventSourcing {

    public static void main(String[] args) {
        Function<Void, Order> createSeed = unit -> null;
        BiFunction<Order, Command, Stream<DomainEvent>> produceNewEvents = (order, command) ->
            command instanceof RegisterNewOrder && validate((RegisterNewOrder) command)
                ? Stream.of(new OrderCreated(((RegisterNewOrder) command).id(), translate(((RegisterNewOrder) command))))
                : Stream.empty();
        BiFunction<Order, DomainEvent, Order> handleEvent = (order, event) ->
            event instanceof OrderCreated
                ? new Order(((OrderCreated) event).getId(), translate(((OrderCreated) event).getLineItems()))
                : order;

        BiFunction<Stream<DomainEvent>, Command, Stream<DomainEvent>> pipeline = buildEventSourcingPipeline(
            createSeed, handleEvent, produceNewEvents);
        RegisterNewOrder command = new RegisterNewOrder(UUID.randomUUID(), List.of(
            new RegisterNewOrderLineItem(UUID.randomUUID(), BigDecimal.valueOf(1500)),
            new RegisterNewOrderLineItem(UUID.randomUUID(), BigDecimal.valueOf(3000))
        ));
        Stream<DomainEvent> stream = Stream.of(new OrderCreated(command.id(), translate(command)));
        Stream<DomainEvent> eventStream = pipeline.apply(stream, command);
        DomainEvent event = eventStream.findFirst().get();
        if (event instanceof OrderCreated) {
            System.out.println("Order Created");
        }
    }

    private static boolean validate(RegisterNewOrder command) {
        return !command.lineItems().isEmpty() &&
            command.lineItems().stream().noneMatch(i -> i.price().intValue() < 0);
    }

    private static List<OrderLineItemCreated> translate(RegisterNewOrder command) {
        return command.lineItems().stream()
            .map(c -> new OrderLineItemCreated(c.productId(), c.price()))
            .toList();
    }

    private static List<OrderLineItem> translate(List<OrderLineItemCreated> event) {
        return event.stream()
            .map(e -> new OrderLineItem(e.getProductId(), e.getPrice()))
            .toList();
    }

    static <T, U> U foldl(BiFunction<U, T, U> f, U z, Stream<T> xs) {
        Iterator<T> i = xs.iterator();
        U a = z;
        while (i.hasNext()) {
            a = f.apply(a, i.next());
        }
        return a;
    }

    static <T, C, E> BiFunction<Stream<E>, C, Stream<E>> buildEventSourcingPipeline(
        Function<Void, T> createSeed,
        BiFunction<T, E, T> handleEvent,
        BiFunction<T, C, Stream<E>> produceNewEvents
    ) {
        return (pastEvents, command) -> createSeed
            .andThen(seed -> foldl(handleEvent, seed, pastEvents))
            .andThen(state -> produceNewEvents.apply(state, command))
            .apply(null);
    }
}
