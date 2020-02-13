package com.huston.microblog.resource.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Resource {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.4+08:00", comments="Source field: resource.res_id")
    private Long resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_url")
    private String resUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_type")
    private Byte resType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_usage")
    private Byte resUsage;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_cre_time")
    private Date resCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.406+08:00", comments="Source field: resource.res_id")
    public Long getResId() {
        return resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_id")
    public void setResId(Long resId) {
        this.resId = resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_url")
    public String getResUrl() {
        return resUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_url")
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_type")
    public Byte getResType() {
        return resType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_type")
    public void setResType(Byte resType) {
        this.resType = resType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_usage")
    public Byte getResUsage() {
        return resUsage;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_usage")
    public void setResUsage(Byte resUsage) {
        this.resUsage = resUsage;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_cre_time")
    public Date getResCreTime() {
        return resCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.407+08:00", comments="Source field: resource.res_cre_time")
    public void setResCreTime(Date resCreTime) {
        this.resCreTime = resCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.408+08:00", comments="Source field: resource.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.408+08:00", comments="Source field: resource.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}