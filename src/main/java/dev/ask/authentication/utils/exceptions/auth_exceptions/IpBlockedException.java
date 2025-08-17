package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class IpBlockedException extends AuthenticationException {
    public IpBlockedException() {
        super(
                AuthErrorCodes.IP_BLOCKED.getCode(),
                AuthErrorCodes.IP_BLOCKED.getTitle(),
                AuthErrorCodes.IP_BLOCKED.getMessage(),
                AuthErrorCodes.IP_BLOCKED.getUri(),
                HttpStatus.FORBIDDEN);
    }
}