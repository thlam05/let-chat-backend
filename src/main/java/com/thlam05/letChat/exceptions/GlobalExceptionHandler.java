package com.thlam05.letchat.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thlam05.letchat.dtos.responses.APIResponse;
import com.thlam05.letchat.enums.ResponseCode;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<APIResponse<Void>> handlingAppException(AppException exception) {
        ResponseCode code = exception.getCode();
        APIResponse<Void> apiResponse = new APIResponse<>(null);

        apiResponse.setCode(code.getCode());
        apiResponse.setMessage(code.getMessage());

        return ResponseEntity.status(code.getStatus()).body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<APIResponse<Void>> handlingMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        ResponseCode code = ResponseCode.BAD_REQUEST;
        APIResponse<Void> apiResponse = new APIResponse<>(null);

        apiResponse.setCode(code.getCode());
        apiResponse.setMessage(exception.getBindingResult()
                .getFieldError()
                .getDefaultMessage());

        return ResponseEntity.status(code.getStatus()).body(apiResponse);
    }
}
