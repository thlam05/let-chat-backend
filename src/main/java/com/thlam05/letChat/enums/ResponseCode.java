package com.thlam05.letChat.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(0, "Successfully", HttpStatus.OK),
    BAD_REQUEST(1, "Bad request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(2, "You are unauthenticated", HttpStatus.UNAUTHORIZED),
    FORBIDDEN(3, "You do not have permission", HttpStatus.FORBIDDEN),
    NOT_FOUND(4, "Can not find", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(5, "Server is error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus status;
}
