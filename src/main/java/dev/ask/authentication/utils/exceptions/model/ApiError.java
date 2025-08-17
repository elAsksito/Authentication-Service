package dev.ask.authentication.utils.exceptions.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiError {
    private String errorCode;
    private String errorTitle;
    private String errorDescription;
    private String errorUri;
    private String errorType;
    private String errorStatus;
    private String errorTimestamp;
    private int httpStatus;
    private Object extraData;
}