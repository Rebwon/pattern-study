package com.rebwon.event_sourcing;

import java.math.BigDecimal;
import java.util.UUID;

public final class OrderLineItem {

    private final UUID productId;
    private final BigDecimal price;

    public OrderLineItem(UUID productId, BigDecimal price) {
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
