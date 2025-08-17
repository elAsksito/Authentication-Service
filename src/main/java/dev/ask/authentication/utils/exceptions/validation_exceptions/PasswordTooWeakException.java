package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class PasswordTooWeakException extends ValidationException {
    public PasswordTooWeakException() {
        super(
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getCode(),
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getTitle(),
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getMessage(),
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getField());
    }
}