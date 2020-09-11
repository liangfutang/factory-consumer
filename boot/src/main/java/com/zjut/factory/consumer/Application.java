package com.zjut.factory.consumer;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjut.dubbo.consumer.mapper")
@DubboComponentScan(basePackages = {"com.zjut.factory.consumer.call.impl"})
//@EnableTransactionManagement
//@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
