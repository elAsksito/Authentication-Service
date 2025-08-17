package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class ExpiredJwtTokenException extends AuthenticationException {
    public ExpiredJwtTokenException() {
        super(
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getCode(),
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getTitle(),
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getMessage(),
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}