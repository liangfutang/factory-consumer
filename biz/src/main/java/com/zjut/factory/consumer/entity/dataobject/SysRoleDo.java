package com.zjut.factory.consumer.entity.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("sys_role")
@Data
public class SysRoleDo {

    @TableId("role_id")
    private Integer roleId;

    private String roleName;

    private String roleSign;

    private String remark;

    private Integer userIdCreate;

    private Date gmtCreate;

    private Date gmtModified;
}
