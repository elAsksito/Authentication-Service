package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class NotAuthenticatedException extends AuthenticationException {
    public NotAuthenticatedException() {
        super(
                AuthErrorCodes.NOT_AUTHENTICATED.getCode(),
                AuthErrorCodes.NOT_AUTHENTICATED.getTitle(),
                AuthErrorCodes.NOT_AUTHENTICATED.getMessage(),
                AuthErrorCodes.NOT_AUTHENTICATED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}