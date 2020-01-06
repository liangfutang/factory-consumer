package com.zjut.factory.consumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjut.factory.consumer.entity.dataobject.SysRoleDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 已经在启动文件上加了扫描包，所以不需要再加@Mapper注解
 */
@Mapper
public interface RoleMapper extends BaseMapper<SysRoleDo> {
}
