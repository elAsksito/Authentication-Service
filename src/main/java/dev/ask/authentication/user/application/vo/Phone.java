package dev.ask.authentication.user.application.vo;

import dev.ask.authentication.utils.exceptions.validation_exceptions.PhoneInvalidFormatException;
import dev.ask.authentication.utils.exceptions.validation_exceptions.PhoneRequiredException;

public record Phone(String value) {
    private static final String PHONE_PATTERN = "^[0-9]{9}$";

    public Phone {
        if (value == null || value.isBlank()) {
            throw new PhoneRequiredException();
        }
        if (!value.matches(PHONE_PATTERN)) {
            throw new PhoneInvalidFormatException();
        }
    }
}
