package io.glitchtech.customer.messaging;

import io.glitchtech.customer.messaging.event.CustomerEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Configuration
public class CustomerMessaging {

    @Bean
    public Sinks.Many<CustomerEvent> customerProducer() {
        return Sinks.many().replay().latest();
    }

    @Bean
    public Supplier<Flux<CustomerEvent>> customerSupplier() {
        return () -> customerProducer().asFlux();
    }
}
