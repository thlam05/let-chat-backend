package com.thlam05.letchat.exceptions;

import com.thlam05.letchat.enums.ResponseCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
    private ResponseCode code;

    public AppException(ResponseCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
