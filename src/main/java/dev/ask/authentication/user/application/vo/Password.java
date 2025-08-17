package dev.ask.authentication.user.application.vo;

import dev.ask.authentication.utils.exceptions.validation_exceptions.PasswordRequiredException;
import dev.ask.authentication.utils.exceptions.validation_exceptions.PasswordTooShortException;
import dev.ask.authentication.utils.exceptions.validation_exceptions.PasswordTooWeakException;

public record Password(String value) {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

    public Password {
        if (value == null || value.isBlank()) {
            throw new PasswordRequiredException();
        }
        if (value.length() < 8) {
            throw new PasswordTooShortException();
        }
        if (!value.matches(PASSWORD_PATTERN)) {
            throw new PasswordTooWeakException();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
