package com.rebwon.event_sourcing;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class OrderCreated implements DomainEvent {

    private final UUID id;
    private final List<OrderLineItemCreated> lineItems;
    private final Date occurredOn;

    public OrderCreated(UUID id, List<OrderLineItemCreated> lineItems) {
        this.id = id;
        this.lineItems = lineItems;
        this.occurredOn = new Date();
    }

    @Override
    public Date occurredOn() {
        return occurredOn;
    }

    public UUID getId() {
        return id;
    }

    public List<OrderLineItemCreated> getLineItems() {
        return lineItems;
    }
}
