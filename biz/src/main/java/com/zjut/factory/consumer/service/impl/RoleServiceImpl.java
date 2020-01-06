package com.zjut.factory.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjut.factory.consumer.entity.dataobject.SysRoleDo;
import com.zjut.factory.consumer.mapper.RoleMapper;
import com.zjut.factory.consumer.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRoleDo> implements RoleService {

    @Override
    public void getRole() {
        List<SysRoleDo> roles = baseMapper.selectByMap(new HashMap<String, Object>() {{
            put("role_id", 1);
        }});
        System.out.println("查询结果:" + roles);
    }
}
