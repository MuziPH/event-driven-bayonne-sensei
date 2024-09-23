package io.glitchtech.customer.service;

import io.glitchtech.customer.domain.Customer;
import io.glitchtech.customer.domain.EmailAddress;
import io.glitchtech.customer.dto.CustomerDTO;
import io.glitchtech.customer.messaging.event.CustomerEvent;
import io.glitchtech.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Sinks.Many<CustomerEvent> customerProducer;

    // Create a Customer and create an event
    @Override
    public Customer create(final Customer customer) {
        Customer customerCreated = customerRepository.save(customer); //DB
        var customerCreatedEvent = new CustomerEvent.CustomerCreated(
                customerCreated.getId(), Instant.now(), CustomerMapper.mapToCustomerDTO(customerCreated));
        customerProducer.tryEmitNext(customerCreatedEvent);
        return customerCreated; // return to Controller
    }

    @Override
    public void changeEmail(Long customerId, EmailAddress emailAddress) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Could not find a customer with id: %s", customerId)));
        customer.changeEmailAddress(emailAddress);
        this.customerRepository.save(customer);
    }

    interface CustomerMapper {
        static CustomerDTO mapToCustomerDTO(final Customer customerCreated) {
            return new CustomerDTO(
                    customerCreated.getFirstName().getFirstNameValue(),
                    customerCreated.getLastName().getLastNameValue(),
                    customerCreated.getBirthDate().getBirthDateValue(),
                    customerCreated.getEmailAddress().getEmailAddressValue(),
                    customerCreated.getSsn()
            );
        }
    }
}
