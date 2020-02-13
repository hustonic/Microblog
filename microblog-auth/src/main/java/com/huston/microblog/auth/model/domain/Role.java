package com.huston.microblog.auth.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Role {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_id")
    private Long roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_name")
    private String roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_desc")
    private String roleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_cre_time")
    private Date roleCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_id")
    public Long getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_id")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_name")
    public String getRoleName() {
        return roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.018+08:00", comments="Source field: role.role_name")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_desc")
    public String getRoleDesc() {
        return roleDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_desc")
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_cre_time")
    public Date getRoleCreTime() {
        return roleCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_cre_time")
    public void setRoleCreTime(Date roleCreTime) {
        this.roleCreTime = roleCreTime;
    }
}