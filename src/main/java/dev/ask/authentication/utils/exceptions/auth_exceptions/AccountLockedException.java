package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class AccountLockedException extends AuthenticationException {
    public AccountLockedException() {
        super(
                AuthErrorCodes.ACCOUNT_LOCKED.getCode(),
                AuthErrorCodes.ACCOUNT_LOCKED.getTitle(),
                AuthErrorCodes.ACCOUNT_LOCKED.getMessage(),
                AuthErrorCodes.ACCOUNT_LOCKED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}