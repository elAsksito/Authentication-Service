package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {
    public InvalidCredentialsException() {
        super(
                AuthErrorCodes.INVALID_CREDENTIALS.getCode(),
                AuthErrorCodes.INVALID_CREDENTIALS.getTitle(),
                AuthErrorCodes.INVALID_CREDENTIALS.getMessage(),
                AuthErrorCodes.INVALID_CREDENTIALS.getUri(),
                HttpStatus.FORBIDDEN);
    }
}