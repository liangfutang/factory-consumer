package com.zjut.dubbo.consumer.service.impl;

import com.zjut.dubbo.consumer.entity.dataobject.SysRoleDo;
import com.zjut.dubbo.consumer.mapper.RoleMapper;
import com.zjut.dubbo.consumer.service.RoleBaseService;
import com.zjut.spring.boot.jdbc.extend.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

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
}
