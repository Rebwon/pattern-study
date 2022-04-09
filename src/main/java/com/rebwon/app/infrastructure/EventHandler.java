package com.rebwon.app.infrastructure;

import com.rebwon.app.domain.DomainEvent;

public interface EventHandler {

    void handle(DomainEvent event);
}
