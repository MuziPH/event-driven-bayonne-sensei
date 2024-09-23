package io.glitchtech.customer.messaging.event;

import io.glitchtech.customer.dto.CustomerDTO;

import java.io.Serializable;
import java.time.Instant;

public sealed interface CustomerEvent extends Serializable {
    record CustomerCreated(Long customerId, Instant createdAt, CustomerDTO customerDTO) implements CustomerEvent {
    }

    record EmailChanged(Long customerId, Instant createdAt, CustomerDTO customerDTO) implements CustomerEvent {
    }
}
