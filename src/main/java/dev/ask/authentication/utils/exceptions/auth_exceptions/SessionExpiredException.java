package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class SessionExpiredException extends AuthenticationException {
    public SessionExpiredException() {
        super(
                AuthErrorCodes.SESSION_EXPIRED.getCode(),
                AuthErrorCodes.SESSION_EXPIRED.getTitle(),
                AuthErrorCodes.SESSION_EXPIRED.getMessage(),
                AuthErrorCodes.SESSION_EXPIRED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}