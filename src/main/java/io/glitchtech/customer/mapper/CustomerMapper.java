package io.glitchtech.customer.mapper;

import io.glitchtech.customer.domain.*;
import io.glitchtech.customer.dto.CustomerDTO;

public interface CustomerMapper {
    static Customer mapToCustomer(final CustomerDTO customerDTO) {

        FirstName firstName = FirstName.of(customerDTO.firstName());
        LastName lastName = LastName.of(customerDTO.lastName());
        BirthDate birthDate = BirthDate.of(customerDTO.birthDate());
        EmailAddress emailAddress = EmailAddress.of(customerDTO.emailAddress());
        Integer ssn = customerDTO.ssn();
        return Customer.create(firstName, lastName, birthDate, emailAddress, ssn);
    }
}
