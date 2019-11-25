package com.zjut.dubbo.consumer.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zjut.dubbo.consumer.entity.dataobject.SysRoleDo;
import com.zjut.dubbo.consumer.mapper.RoleMapper;
import com.zjut.dubbo.consumer.service.RoleBaseService;
import com.zjut.spring.boot.jdbc.extend.service.BaseServiceImpl;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleBaseServiceImpl extends BaseServiceImpl<RoleMapper, SysRoleDo> implements RoleBaseService {
    @Override
    public void getRole() {
        List<SysRoleDo> roles = baseMapper.selectByMap(new HashMap<String, Object>() {{
            put("role_id", 1);
        }});
        System.out.println("查询结果:" + roles);
    }

    @Override
    public int update() {
        SysRoleDo sysRoleDo1 = baseMapper.selectById(56);
        sysRoleDo1.setGmtCreate(new Date());
        sysRoleDo1.setRoleSign("admin");
        sysRoleDo1.setRemark(null);

        UpdateWrapper<SysRoleDo> sysRoleDoUpdateWrapper = new UpdateWrapper<>();
        sysRoleDoUpdateWrapper.eq("role_id", sysRoleDo1.getRoleId());

//        int update = baseMapper.update(sysRoleDo1, sysRoleDoUpdateWrapper);
        int update = ((RoleBaseServiceImpl) AopContext.currentProxy()).updateTranscation(sysRoleDo1, sysRoleDoUpdateWrapper);

        System.out.println("打印修改后的结果:" + update);
        return update;
    }

    /**
     * 测试数据库事务
     *
     * @param sysRoleDo1
     * @param sysRoleDoUpdateWrapper
     * @return
     */
    @Transactional(rollbackFor = Exception.class, timeout = 10, isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
    public int updateTranscation(SysRoleDo sysRoleDo1, UpdateWrapper<SysRoleDo> sysRoleDoUpdateWrapper) {
        SysRoleDo sysRoleDotem = baseMapper.selectById(sysRoleDo1.getRoleId());
        int update = baseMapper.update(sysRoleDo1, sysRoleDoUpdateWrapper);
        SysRoleDo sysRoleDotem1 = baseMapper.selectById(sysRoleDo1.getRoleId());
        if (true) {
            throw  new RuntimeException();
        }
        return update;
    }
}
