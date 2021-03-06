package com.zjut.factory.consumer.service;

import com.zjut.factory.consumer.entity.dataobject.SysRoleDo;
import com.zjut.spring.boot.jdbc.extend.service.BaseService;

/**
 * 用来测试使用自己封装过的基础baseService
 */
public interface RoleBaseService extends BaseService<SysRoleDo> {

    /**
     * 测试用
     */
    void getRole();

    /**
     * 用来测试事务的更新方法
     *
     * @return
     */
    int update();

    /**
     * 幻读测试
     */
    void repeatRead();
}
