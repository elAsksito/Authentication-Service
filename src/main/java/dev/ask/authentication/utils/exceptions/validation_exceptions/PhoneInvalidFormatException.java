package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class PhoneInvalidFormatException extends ValidationException {
    public PhoneInvalidFormatException() {
        super(
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getCode(),
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getTitle(),
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getMessage(),
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getField());
    }
}