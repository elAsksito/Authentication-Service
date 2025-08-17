package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class PasswordTooShortException extends ValidationException {
    public PasswordTooShortException() {
        super(
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getCode(),
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getTitle(),
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getMessage(),
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getField());
    }
}