package com.zjut.dubbo.consumer.call.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zjut.dubbo.consumer.call.TestDubboService;
import com.zjut.dubbo.provider.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestDubboServiceImpl implements TestDubboService {

    @Reference(version = "1.0.0",timeout = 300)
    private TestService testService;

    @Override
    public String testValidate() {
        String test = testService.getTest();
        System.out.println("收到生产者提供的消息:" + test);
        return "success";
    }
}
