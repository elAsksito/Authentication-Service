package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class PhoneRequiredException extends ValidationException {
    public PhoneRequiredException() {
        super(
                ValidationErrorCodes.PHONE_REQUIRED.getCode(),
                ValidationErrorCodes.PHONE_REQUIRED.getTitle(),
                ValidationErrorCodes.PHONE_REQUIRED.getMessage(),
                ValidationErrorCodes.PHONE_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PHONE_REQUIRED.getField());
    }
}