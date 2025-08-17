package dev.ask.authentication.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import dev.ask.authentication.utils.exceptions.builder.ApiErrorBuilder;
import dev.ask.authentication.utils.exceptions.model.ApiError;
import dev.ask.authentication.utils.exceptions.model.AuthenticationException;
import dev.ask.authentication.utils.exceptions.model.ValidationException;
import reactor.core.publisher.Mono;

@Component
public class GlobalExceptionFilter implements HandlerFilterFunction<ServerResponse, ServerResponse>{

    @Override
    @NonNull
    public Mono<ServerResponse> filter(@NonNull ServerRequest request, @NonNull HandlerFunction<ServerResponse> next) {
        return next.handle(request)
                .onErrorResume(ex -> {
                    if (ex instanceof AuthenticationException authEx) {
                        ApiError error = ApiErrorBuilder.buildApiError(
                                authEx.getErrorCode(),
                                authEx.getErrorTitle(),
                                authEx.getErrorDescription(),
                                authEx.getErrorUri(),
                                authEx.getHttpStatus(),
                                authEx.getClass().getSimpleName(),
                                null
                        );
                        return ServerResponse
                                .status(authEx.getHttpStatus())
                                .bodyValue(error);
                    } else if (ex instanceof ValidationException valEx) {
                        ApiError error = ApiErrorBuilder.buildApiError(
                                valEx.getErrorCode(),
                                valEx.getErrorTitle(),
                                valEx.getErrorDescription(),
                                valEx.getErrorUri(),
                                valEx.getHttpStatus(),
                                valEx.getClass().getSimpleName(),
                                valEx.getFieldErrors()
                        );
                        return ServerResponse
                                .status(valEx.getHttpStatus())
                                .bodyValue(error);
                    }

                    ApiError genericError = ApiErrorBuilder.buildApiError(
                            "GEN-001",
                            "Unexpected Error",
                            ex.getMessage(),
                            "",
                            HttpStatus.BAD_REQUEST,
                            ex.getClass().getSimpleName(),
                            null
                    );
                    return ServerResponse.status(500).bodyValue(genericError);
                });
    }
    
}