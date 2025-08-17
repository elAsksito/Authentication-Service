package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class EmailInvalidFormatException extends ValidationException {
    public EmailInvalidFormatException() {
        super(
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getCode(),
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getTitle(),
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getMessage(),
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getField());
    }
}