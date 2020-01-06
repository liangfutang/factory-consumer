package com.zjut.factory.consumer.controller;

import com.zjut.factory.consumer.common.response.RestResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instance")
//@Scope("prototype") //默认的情况下是单例，加上该注解就是多例了
public class TestSingletonAndMultipleController {

    private int i;

    /**
     * 测试全局变量是否会增加，单例的话会，多例的话不会
     * 返回的结果是会变化
     * @return
     */
    @PutMapping("/test1")
    public RestResponse getI1() {
        i++;
        return new RestResponse(i);
    }

}
