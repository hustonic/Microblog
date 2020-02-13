package com.huston.microblog.auth.model.domain;

import javax.annotation.Generated;

public class RolePermission {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source field: role_permission.role_perm_id")
    private Long rolePermId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.role_id")
    private Long roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.perm_id")
    private Long permId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source field: role_permission.role_perm_id")
    public Long getRolePermId() {
        return rolePermId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source field: role_permission.role_perm_id")
    public void setRolePermId(Long rolePermId) {
        this.rolePermId = rolePermId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.role_id")
    public Long getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.role_id")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.perm_id")
    public Long getPermId() {
        return permId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.perm_id")
    public void setPermId(Long permId) {
        this.permId = permId;
    }
}