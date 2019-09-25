package com.zjut.dubbo.consumer.service;

import com.zjut.dubbo.consumer.entity.dataobject.SysRoleDo;
import com.zjut.spring.boot.jdbc.extend.service.BaseService;

/**
 * 用来测试使用自己封装过的基础baseService
 */
public interface RoleBaseService extends BaseService<SysRoleDo> {

    /**
     * 测试用
     */
    void getRole();
}
