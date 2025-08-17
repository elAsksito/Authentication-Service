package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class AccountExpiredException extends AuthenticationException {
    public AccountExpiredException() {
        super(
                AuthErrorCodes.ACCOUNT_EXPIRED.getCode(),
                AuthErrorCodes.ACCOUNT_EXPIRED.getTitle(),
                AuthErrorCodes.ACCOUNT_EXPIRED.getMessage(),
                AuthErrorCodes.ACCOUNT_EXPIRED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}