package io.glitchtech.customer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.Objects;

@Embeddable
public class FirstName {
    @Column(name = "firstName")
    private String firstNameValue;

    private FirstName() {
    }

    private FirstName(String value) {
        this.firstNameValue = value;
    }

    public static FirstName of(final String value) {
        Objects.requireNonNull(value, "The value of first name cannot be null");
        Assert.isTrue(!value.isBlank(), "The value of first name cannot be empty");
        return new FirstName(value);
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }
}
