package io.glitchtech.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private FirstName firstName;
    private LastName lastName;
    private BirthDate birthDate;
    private EmailAddress emailAddress;

    private Customer(FirstName firstName, LastName lastName, BirthDate birthDate, EmailAddress emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
    }

    public static Customer create(FirstName firstName, LastName lastName,
                                  BirthDate birthDate, EmailAddress emailAddress) {
        return new Customer(firstName, lastName, birthDate, emailAddress);
    }

    public void changeEmailAddress(final EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }
}
