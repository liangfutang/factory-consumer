package com.zjut.factory.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjut.factory.consumer.call.TestDubboService;
import com.zjut.factory.consumer.common.response.RestResponse;
import com.zjut.factory.consumer.service.RoleBaseService;
import com.zjut.factory.consumer.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleBaseService roleBaseService;
    @Autowired
    private TestDubboService testDubboService;

    @GetMapping("/testDubboValidation")
    public RestResponse testDubbo() {
        testDubboService.testValidate();
        return new RestResponse("success");
    }

    /**
     * 测试dubbo分组
     * @return
     */
    @GetMapping("/testDubboGroup")
    public RestResponse testDubboGroup() {
        testDubboService.testDubboGroup();
        return new RestResponse("success");
    }

    @RequestMapping("/test")
    public RestResponse test() {
        logger.info("日志测试");
        System.out.println("进入到测试方法");
        return new RestResponse("test success");
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

    @GetMapping("/getRole")
    public RestResponse getRole() {
        System.out.println("============开始测试baomidou的===========");
        roleService.getRole();
        System.out.println("============结束测试baomidou的===========");

        System.out.println("============开始测试自己封装的===========");
        roleBaseService.getRole();
        System.out.println("============结束测试自己封装的===========");
        return new RestResponse("success");
    }

    @GetMapping("/updateRole")
    public RestResponse updateRole () {
        return new RestResponse(roleBaseService.update());
    }

    @GetMapping("/repeatRead")
    public RestResponse repeatRead() {
        roleBaseService.repeatRead();
        return new RestResponse(null);
    }
}
