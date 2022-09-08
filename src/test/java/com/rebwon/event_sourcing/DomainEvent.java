package com.rebwon.event_sourcing;

import java.util.Date;

public interface DomainEvent {

    Date occurredOn();
}
