package io.glitchtech.customer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Objects;

@Embeddable
public class LastName {
    @Column(name = "lastName")
    private String lastNameValue;

    private LastName() {
    }

    private LastName(String value) {
        this.lastNameValue = value;
    }

    public static LastName of(final String value) {
        Objects.requireNonNull(value, "The value of last name cannot be null");
        Assert.isTrue(!value.isBlank(), "The value of last name cannot be empty");
        return new LastName(value);
    }

    public String getLastNameValue() {
        return lastNameValue;
    }
}
