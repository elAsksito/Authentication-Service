package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class EmailRequiredException extends ValidationException {
    public EmailRequiredException() {
        super(
                ValidationErrorCodes.EMAIL_REQUIRED.getCode(),
                ValidationErrorCodes.EMAIL_REQUIRED.getTitle(),
                ValidationErrorCodes.EMAIL_REQUIRED.getMessage(),
                ValidationErrorCodes.EMAIL_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.EMAIL_REQUIRED.getField());
    }
}