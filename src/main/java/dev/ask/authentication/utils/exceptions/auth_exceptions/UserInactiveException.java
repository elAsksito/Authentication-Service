package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class UserInactiveException extends AuthenticationException {
    public UserInactiveException() {
        super(
                AuthErrorCodes.USER_INACTIVE.getCode(),
                AuthErrorCodes.USER_INACTIVE.getTitle(),
                AuthErrorCodes.USER_INACTIVE.getMessage(),
                AuthErrorCodes.USER_INACTIVE.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}