package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class EmailNotVerifiedException extends AuthenticationException {
    public EmailNotVerifiedException() {
        super(
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getCode(),
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getTitle(),
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getMessage(),
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}