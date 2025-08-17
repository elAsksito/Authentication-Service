package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class PasswordRequiredException extends ValidationException {
    public PasswordRequiredException() {
        super(
                ValidationErrorCodes.PASSWORD_REQUIRED.getCode(),
                ValidationErrorCodes.PASSWORD_REQUIRED.getTitle(),
                ValidationErrorCodes.PASSWORD_REQUIRED.getMessage(),
                ValidationErrorCodes.PASSWORD_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PASSWORD_REQUIRED.getField());
    }
}