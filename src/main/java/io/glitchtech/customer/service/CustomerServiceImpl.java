package io.glitchtech.customer.service;

import io.glitchtech.customer.domain.Customer;
import io.glitchtech.customer.domain.EmailAddress;
import io.glitchtech.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
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
