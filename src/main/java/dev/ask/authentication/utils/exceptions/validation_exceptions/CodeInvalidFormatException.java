package dev.ask.authentication.utils.exceptions.validation_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.ValidationErrorCodes;
import dev.ask.authentication.utils.exceptions.model.ValidationException;

public class CodeInvalidFormatException extends ValidationException {
    public CodeInvalidFormatException() {
        super(
                ValidationErrorCodes.CODE_INVALID_FORMAT.getCode(),
                ValidationErrorCodes.CODE_INVALID_FORMAT.getTitle(),
                ValidationErrorCodes.CODE_INVALID_FORMAT.getMessage(),
                ValidationErrorCodes.CODE_INVALID_FORMAT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.CODE_INVALID_FORMAT.getField());
    }
}