package com.zjut.dubbo.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjut.dubbo.consumer.common.response.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    public RestResponse test() {
        logger.info("日志测试");
        System.out.println("进入到测试方法");
        return new RestResponse("test ssuccess");
    }

    @GetMapping("/testThreadPool")
    public RestResponse testThreadPool() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i=0; i<10; i++) {
            ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://localhost:8080/test/testThreadPool", JSONObject.class);
            Thread.sleep(3000);
        }


        return new RestResponse("success");
    }
}
