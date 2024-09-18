package io.glitchtech.customer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailAddressTest {
    @Test
    void of(){
        var expectedEmailAddress = "muzi@gmail.com";

        EmailAddress actualEmailAddress =  EmailAddress.of(expectedEmailAddress);
        Assertions.assertNotNull(actualEmailAddress);
        Assertions.assertEquals(expectedEmailAddress, actualEmailAddress.getEmailAddressValue());
    }

    void ofNullValue(){
        EmailAddress of = EmailAddress.of(null);
        NullPointerException nullPointerException = Assertions.assertThrows(
                NullPointerException.class,
                () -> EmailAddress.of(null)
        );
        Assertions.assertEquals("The email address cannot be null", nullPointerException.getMessage());
    }
}
