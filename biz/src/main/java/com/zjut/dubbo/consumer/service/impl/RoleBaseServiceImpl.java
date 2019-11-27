package com.zjut.dubbo.consumer.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zjut.dubbo.consumer.entity.dataobject.SysRoleDo;
import com.zjut.dubbo.consumer.mapper.RoleMapper;
import com.zjut.dubbo.consumer.service.RoleBaseService;
import com.zjut.spring.boot.jdbc.extend.service.BaseServiceImpl;
import lombok.extern.java.Log;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log
public class RoleBaseServiceImpl extends BaseServiceImpl<RoleMapper, SysRoleDo> implements RoleBaseService {

    @Autowired
    @Lazy
    private RoleBaseService roleBaseService;

    @Autowired
    @Lazy
    ApplicationContext applicationContext;

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
        sysRoleDo1.setRoleSign("admin212vv");
        sysRoleDo1.setRemark(null);

        UpdateWrapper<SysRoleDo> sysRoleDoUpdateWrapper = new UpdateWrapper<>();
        sysRoleDoUpdateWrapper.eq("role_id", sysRoleDo1.getRoleId());

//        int update = baseMapper.update(sysRoleDo1, sysRoleDoUpdateWrapper);
        // 方式一
//        int update = ((RoleBaseServiceImpl) AopContext.currentProxy()).updateTranscation(sysRoleDo1, sysRoleDoUpdateWrapper);
        // 方式二
        this.roleBaseService.getRole();
        // 方式三
        int update  = ((RoleBaseServiceImpl) applicationContext.getBean("roleBaseServiceImpl")).updateTranscation(sysRoleDo1, sysRoleDoUpdateWrapper);
//        int update  = ((RoleBaseServiceImpl) applicationContext.getBean("roleBaseServiceImpl")).updateTranscation1();

        System.out.println("打印修改后的结果:" + update);
        return update;
    }

    /**
     * 幻读测试
     */
    @Transactional(rollbackFor = Exception.class, timeout = 10000, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void repeatRead() {
        Map<String, Object> map = new HashMap<>();
        map.put("role_sign", "admin");
        List<SysRoleDo> sysRoleDos = baseMapper.selectByMap(map);
        System.out.println("显示第一次查到的结果：" + sysRoleDos);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<SysRoleDo> sysRoleDos1 = baseMapper.selectByMap(map);
        System.out.println("显示第二次查到的结果：" + sysRoleDos1);
    }

    /**
     * 测试数据库事务，脏读测试
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
        updateTranscation1();
        if (false) {
            log.info("进入到外部方法");
            throw  new RuntimeException();
        }
        return update;
    }

    /**
     * 用来测试嵌套的事务
     * 作为嵌套的事务，这里的
     *
     * @return
     */
//    @Transactional(rollbackFor = Exception.class, timeout = 10, isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public int updateTranscation1() {
        SysRoleDo sysRoleDo1 = baseMapper.selectById(57);
        sysRoleDo1.setGmtCreate(new Date());
        sysRoleDo1.setRoleSign("admin212vvsss");
        sysRoleDo1.setRemark(null);
        UpdateWrapper<SysRoleDo> sysRoleDoUpdateWrapper = new UpdateWrapper<>();
        sysRoleDoUpdateWrapper.eq("role_id", sysRoleDo1.getRoleId());
        SysRoleDo sysRoleDotem = baseMapper.selectById(sysRoleDo1.getRoleId());
        int update = baseMapper.update(sysRoleDo1, sysRoleDoUpdateWrapper);
        SysRoleDo sysRoleDotem1 = baseMapper.selectById(sysRoleDo1.getRoleId());
        if (false) {
            throw  new RuntimeException();
        }
        return update;
    }
}
