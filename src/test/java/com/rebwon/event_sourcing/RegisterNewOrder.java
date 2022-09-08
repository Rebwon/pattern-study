package com.rebwon.event_sourcing;

import java.util.List;
import java.util.UUID;

public record RegisterNewOrder(
    UUID id,
    List<RegisterNewOrderLineItem> lineItems
) implements Command {}


