package com.huston.microblog.mblog.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Collect {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.648+08:00", comments="Source field: collect.collect_id")
    private Long collectId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.mblog_id")
    private Long mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.collect_time")
    private Date collectTime;

    public Collect() {
    }

    public Collect(Long userId, Long mblogId, Date collectTime) {
        this.userId = userId;
        this.mblogId = mblogId;
        this.collectTime = collectTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.648+08:00", comments="Source field: collect.collect_id")
    public Long getCollectId() {
        return collectId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.collect_id")
    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.mblog_id")
    public Long getMblogId() {
        return mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.mblog_id")
    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.collect_time")
    public Date getCollectTime() {
        return collectTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.649+08:00", comments="Source field: collect.collect_time")
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}