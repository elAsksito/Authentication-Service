package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class CodeRequiredException extends ValidationException {
    public CodeRequiredException() {
        super(
                ValidationErrorCodes.CODE_REQUIRED.getCode(),
                ValidationErrorCodes.CODE_REQUIRED.getTitle(),
                ValidationErrorCodes.CODE_REQUIRED.getMessage(),
                ValidationErrorCodes.CODE_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.CODE_REQUIRED.getField());
    }
}