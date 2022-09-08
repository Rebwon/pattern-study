package com.rebwon.event_sourcing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Order implements Entity {

    private final UUID id;
    private final List<OrderLineItem> lineItems = new ArrayList<>();

    public Order(UUID id, List<OrderLineItem> lineItems) {
        this.id = id;
    }

    @Override
    public UUID id() {
        return id;
    }
}
