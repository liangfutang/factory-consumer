package com.zjut.factory.consumer.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class RestResponse {

    private boolean success;

    private Object data;

    private Integer errorCode;

    private String message;

    private String sessionId;

    public RestResponse(Object data) {
        this.dafultFileds(true, data, errorCode, null);
    }

    public RestResponse(boolean success, Object data, Integer errorCode, String message) {
        dafultFileds(success, data, errorCode, message);
    }

    private void dafultFileds(boolean success, Object data, Integer errorCode,String message) {
        this.success =success;
        this.data = data;
        this.errorCode = errorCode;
        this.message = message;
    }
}
