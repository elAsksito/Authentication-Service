package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class InvalidJwtTokenException extends AuthenticationException {
    public InvalidJwtTokenException() {
        super(
                AuthErrorCodes.INVALID_JWT_TOKEN.getCode(),
                AuthErrorCodes.INVALID_JWT_TOKEN.getTitle(),
                AuthErrorCodes.INVALID_JWT_TOKEN.getMessage(),
                AuthErrorCodes.INVALID_JWT_TOKEN.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}