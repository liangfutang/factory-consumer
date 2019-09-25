package com.zjut.dubbo.consumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjut.dubbo.consumer.entity.dataobject.SysRoleDo;

/**
 * 用来测试直接继承baomidou提供的基础baseService
 */
public interface RoleService extends IService<SysRoleDo> {

    /**
     * 测试用
     */
    void getRole();
}
