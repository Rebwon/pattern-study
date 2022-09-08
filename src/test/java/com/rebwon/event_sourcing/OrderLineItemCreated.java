package com.rebwon.event_sourcing;

import java.math.BigDecimal;
import java.util.UUID;

public final class OrderLineItemCreated {

    private final UUID productId;
    private final BigDecimal price;

    public OrderLineItemCreated(UUID productId, BigDecimal price) {
        this.productId = productId;
        this.price = price;
    }

    public UUID getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
