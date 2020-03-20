package com.zjut.factory.consumer.call;

public interface TestDubboService {
//    String getTest();

    /**
     * 测试入参校验的有效性
     *
     * @return
     */
    String testValidate();

    /**
     * 测试dubbo分组
     *
     * @return
     */
    String testDubboGroup();

    /**
     * 调提供者接口，测试提供者在入参中添加一个参数
     * @return
     */
    String testDubboAopInserArg();
}
