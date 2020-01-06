package com.zjut.factory.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjut.dubbo.consumer.mapper")
//@EnableTransactionManagement
//@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
