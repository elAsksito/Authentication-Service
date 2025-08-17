package dev.ask.authentication.utils.exceptions.builder;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

import dev.ask.authentication.utils.exceptions.model.ApiError;

public class ApiErrorBuilder {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static ApiError buildApiError(
                        String code,
                        String title,
                        String description,
                        String uri,
                        HttpStatus status,
                        String type,
                        String extraData) {
                return ApiError.builder()
                                .errorCode(code)
                                .errorTitle(title)
                                .errorDescription(description)
                                .errorUri(uri)
                                .errorType(type)
                                .errorStatus(status.toString())
                                .errorTimestamp(ZonedDateTime.now().format(FORMATTER))
                                .httpStatus(status.value())
                                .extraData(extraData)
                                .build();
        }
}