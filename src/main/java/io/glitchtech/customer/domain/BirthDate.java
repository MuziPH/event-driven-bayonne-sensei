package io.glitchtech.customer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class BirthDate {
    @Column(name = "birthDate")
    private LocalDate birthDateValue;

    private BirthDate() {
    }

    private BirthDate(LocalDate date) {
        this.birthDateValue = date;
    }

    public static BirthDate of(LocalDate date) {
        Objects.requireNonNull(date, "Birthdate cannot be null");
        Assert.isTrue(!date.isAfter(LocalDate.now()), "Birthdate cannot be in the future");
        return new BirthDate(date);
    }

    public LocalDate getBirthDateValue() {
        return birthDateValue;
    }
}
