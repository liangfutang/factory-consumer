package com.zjut.dubbo.consumer.config.exception;

import com.zjut.common.constants.CommonConstants;
import com.zjut.dubbo.consumer.common.response.RestResponse;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 拦截所有的接口response，将traceID写进response中
 */
@ControllerAdvice
public class TraceIdGlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof RestResponse) {
            RestResponse restResponse = (RestResponse)o;
            restResponse.setSessionId(MDC.get(CommonConstants.TRACE_ID));
        }
        return o;
    }
}
