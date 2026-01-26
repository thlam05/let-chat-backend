package com.thlam05.letChat.dtos.responses;

import com.thlam05.letChat.enums.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    private int code;
    private String message;
    private T data;
    private boolean success;

    public APIResponse(T data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
        this.data = data;
        this.success = true;
    }
}
