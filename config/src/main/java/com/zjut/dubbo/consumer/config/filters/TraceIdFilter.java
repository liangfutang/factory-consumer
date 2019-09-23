//package com.zjut.dubbo.consumer.config.filters;
//
//import org.slf4j.MDC;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.UUID;
//
//public class TraceIdFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        MDC.put("traceId", UUID.randomUUID().toString());
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
