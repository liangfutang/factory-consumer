package com.zjut.factory.consumer.config.exception;

import com.zjut.factory.consumer.common.response.RestResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public RestResponse exceptionHandle(Exception e) {
        return new RestResponse(false, null, 5001, e.getMessage());
    }
}
