package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class InvalidPasswordException extends AuthenticationException {
    public InvalidPasswordException() {
        super(
                AuthErrorCodes.INVALID_PASSWORD.getCode(),
                AuthErrorCodes.INVALID_PASSWORD.getTitle(),
                AuthErrorCodes.INVALID_PASSWORD.getMessage(),
                AuthErrorCodes.INVALID_PASSWORD.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}