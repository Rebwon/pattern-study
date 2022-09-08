package com.rebwon.event_sourcing;

import java.math.BigDecimal;
import java.util.UUID;

public record RegisterNewOrderLineItem(
    UUID productId,
    BigDecimal price
) implements Command {}
