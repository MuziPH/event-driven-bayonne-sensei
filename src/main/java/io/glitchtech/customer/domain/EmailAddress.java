package io.glitchtech.customer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class EmailAddress {
    @Column(name = "emailAddress")
    private String emailAddressValue;

    private EmailAddress() {
    }

    private EmailAddress(String emailAddressValue) {
        this.emailAddressValue = emailAddressValue;
    }

    public static EmailAddress of(String emailAddress) {
        Objects.requireNonNull(emailAddress, "The email address cannot be null");
        Assert.isTrue(!emailAddress.isBlank(), "The email address cannot be empty");
        var regexPattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        boolean matches = Pattern.compile(regexPattern).matcher(emailAddress).matches();
        Assert.isTrue(matches, "Invalid email address");
        return new EmailAddress(emailAddress);
    }

    public String getEmailAddressValue() {
        return emailAddressValue;
    }

}
