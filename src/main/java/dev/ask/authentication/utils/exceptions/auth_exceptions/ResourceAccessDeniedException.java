package dev.ask.authentication.utils.exceptions.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.enums.AuthErrorCodes;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;

public class ResourceAccessDeniedException extends AuthenticationException {
    public ResourceAccessDeniedException() {
        super(
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getCode(),
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getTitle(),
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getMessage(),
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getUri(),
                HttpStatus.FORBIDDEN);
    }
}