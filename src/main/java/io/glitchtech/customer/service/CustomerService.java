package io.glitchtech.customer.service;

import io.glitchtech.customer.domain.Customer;
import io.glitchtech.customer.domain.EmailAddress;

public interface CustomerService {
    Customer create(Customer customer);
    void changeEmail(Long customerId, EmailAddress emailAddress);
}
