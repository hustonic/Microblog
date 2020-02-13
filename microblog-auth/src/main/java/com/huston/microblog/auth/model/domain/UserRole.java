package com.huston.microblog.auth.model.domain;

import javax.annotation.Generated;

public class UserRole {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_role_id")
    private Long userRoleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.role_id")
    private Long roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_role_id")
    public Long getUserRoleId() {
        return userRoleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_role_id")
    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.role_id")
    public Long getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.role_id")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}