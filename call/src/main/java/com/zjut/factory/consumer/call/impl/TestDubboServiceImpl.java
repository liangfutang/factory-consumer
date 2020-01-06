package com.zjut.factory.consumer.call.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zjut.factory.consumer.call.TestDubboService;
import com.zjut.factory.provider.client.dto.TestDubboValidationDto;
import com.zjut.factory.provider.client.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestDubboServiceImpl implements TestDubboService {

    private static final Logger logger = LoggerFactory.getLogger(TestDubboServiceImpl.class);

    @Reference(version = "1.0.0",timeout = 300, group = "jack")
    private TestService jackTestService;

    @Reference(version = "1.0.0",timeout = 300, group = "rose")
    private TestService roseTestService1;

    @Override
    public String testValidate() {
        String test = jackTestService.getTest();
        logger.info("收到生产者提供的消息:" + test);

        TestDubboValidationDto testDubboValidationDto = new TestDubboValidationDto();
        testDubboValidationDto.setId(12);
        testDubboValidationDto.setAge(23);
        testDubboValidationDto.setName("jack");
        testDubboValidationDto.setSex("f");
        try {
            String s = jackTestService.testValidation(testDubboValidationDto);
            logger.info("显示dubbo入参校验的dubbo接口的返回结果:" + s);
        } catch (Exception e) {
            logger.error("调用dubbo入参校验接口异常:" + e.getMessage());
        }
        return "success";
    }

    @Override
    public String testDubboGroup() {
        String test = jackTestService.getTest();
        logger.info("jack组的调用成功了:" + test);

        String test1 = roseTestService1.getTest();
        logger.info("rose组的调动成功了:" + test1);
        return "success";
    }
}
