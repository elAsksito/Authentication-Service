package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class UnauthorizedAccessException extends AuthenticationException {
    public UnauthorizedAccessException() {
        super(
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getCode(),
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getTitle(),
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getMessage(),
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getUri(),
                HttpStatus.FORBIDDEN);
    }
}