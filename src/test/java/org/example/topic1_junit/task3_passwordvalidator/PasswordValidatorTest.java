package org.example.topic1_junit.task3_passwordvalidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PasswordValidatorTest {

    @Mock
    private PasswordValidator passwordValidator;

    @Test
    void isValidPassword() {
        String password = "password1";
        Assertions.assertTrue(PasswordValidator.isValid(password));
    }

    @Test
    void passwordWithNoNumbers() {
        String password = "password";
        Assertions.assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void passwordWithLengthLessThan8() {
        String password = "passwr1";
        Assertions.assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void emptyPassword() {
        String password = "";
        Assertions.assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void nullPassword() {
        String password = null;
        Assertions.assertFalse(PasswordValidator.isValid(password));
    }
}