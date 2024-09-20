package io.glitchtech.customer.service;

import io.glitchtech.customer.domain.Customer;
import io.glitchtech.customer.domain.EmailAddress;
import io.glitchtech.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final StreamBridge streamBridge;

    @Override
    public Customer create(Customer customer) {
        Customer customerCreated = customerRepository.save(customer);
        streamBridge.send("customer", customerCreated);
        return customerCreated;
    }

    @Override
    public void changeEmail(Long customerId, EmailAddress emailAddress) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Could not find a customer with id: %s", customerId)));
        customer.changeEmailAddress(emailAddress);
        this.customerRepository.save(customer);


    }
}
