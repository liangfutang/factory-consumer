package com.zjut.dubbo.consumer.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResponse {

    private boolean success;

    private Object data;

    private Integer errorCode;

    private String message;

    public RestResponse(Object data) {
        this.dafultFileds(true, data, errorCode, null);
    }

    private void dafultFileds(boolean success, Object data, Integer errorCode,String message) {
        this.success =success;
        this.data = data;
        this.errorCode = errorCode;
        this.message = message;
    }
}
