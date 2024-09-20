package io.glitchtech.customer.messaging;

import io.glitchtech.customer.domain.*;
import io.glitchtech.customer.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Component
public class CustomerMessaging {
    private final CustomerServiceImpl customerService;

    @Bean
    public Supplier<Customer> customerSupplier() {
        return () -> {
                    Customer customerCreated = Customer.create(
                            FirstName.of("Sivabak"),
                            LastName.of("Gorrila"),
                            BirthDate.of(LocalDate.of(1978, Month.NOVEMBER, 17)),
                            EmailAddress.of("silbak@gmail.com")
            );
            return customerCreated;
        };
    }
}
