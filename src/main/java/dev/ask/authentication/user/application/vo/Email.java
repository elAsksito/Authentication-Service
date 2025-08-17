package dev.ask.authentication.user.application.vo;

import java.util.regex.Pattern;

import dev.ask.authentication.utils.exceptions.validation_exceptions.EmailInvalidFormatException;
import dev.ask.authentication.utils.exceptions.validation_exceptions.EmailRequiredException;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public Email {
        if (value == null || value.isBlank()) {
            throw new EmailRequiredException();
        }

        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new EmailInvalidFormatException();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
