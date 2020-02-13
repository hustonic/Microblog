package com.huston.microblog.auth.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Permission {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_id")
    private Long permId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_name")
    private String permName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_desc")
    private String permDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_url")
    private String permUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_cre_time")
    private Date permCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_id")
    public Long getPermId() {
        return permId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_id")
    public void setPermId(Long permId) {
        this.permId = permId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_name")
    public String getPermName() {
        return permName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_name")
    public void setPermName(String permName) {
        this.permName = permName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_desc")
    public String getPermDesc() {
        return permDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_desc")
    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_url")
    public String getPermUrl() {
        return permUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_url")
    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_cre_time")
    public Date getPermCreTime() {
        return permCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source field: permission.perm_cre_time")
    public void setPermCreTime(Date permCreTime) {
        this.permCreTime = permCreTime;
    }
}