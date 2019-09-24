package com.zjut.dubbo.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjut.dubbo.consumer.entity.dataobject.SysRoleDo;
import com.zjut.dubbo.consumer.mapper.RoleMapper;
import com.zjut.dubbo.consumer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
