package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class UserAlreadyExistException extends AuthenticationException {
    public UserAlreadyExistException() {
        super(
                AuthErrorCodes.USER_ALREADY_EXISTS.getCode(),
                AuthErrorCodes.USER_ALREADY_EXISTS.getTitle(),
                AuthErrorCodes.USER_ALREADY_EXISTS.getMessage(),
                AuthErrorCodes.USER_ALREADY_EXISTS.getUri(),
                HttpStatus.BAD_REQUEST);
    }
}