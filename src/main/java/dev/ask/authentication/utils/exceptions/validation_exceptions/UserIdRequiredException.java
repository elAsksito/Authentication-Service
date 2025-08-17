package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class UserIdRequiredException extends ValidationException {
    public UserIdRequiredException() {
        super(
                ValidationErrorCodes.USER_ID_REQUIRED.getCode(),
                ValidationErrorCodes.USER_ID_REQUIRED.getTitle(),
                ValidationErrorCodes.USER_ID_REQUIRED.getMessage(),
                ValidationErrorCodes.USER_ID_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.USER_ID_REQUIRED.getField());
    }
}