package io.glitchtech.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class Customer {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private FirstName firstName;
    private LastName lastName;
    private BirthDate birthDate;
    private EmailAddress emailAddress;
    private Integer ssn;

    private Customer(FirstName firstName, LastName lastName, BirthDate birthDate, EmailAddress emailAddress, Integer ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.ssn = ssn;
    }

    public static Customer create(FirstName firstName, LastName lastName,
                                  BirthDate birthDate, EmailAddress emailAddress, Integer ssn) {
        return new Customer(firstName, lastName, birthDate, emailAddress, ssn);
    }

    public void changeEmailAddress(final EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}
