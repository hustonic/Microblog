package com.huston.microblog.mblog.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class AgreeMicroblog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.644+08:00", comments="Source field: agree_microblog.agree_id")
    private Long agreeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.644+08:00", comments="Source field: agree_microblog.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.mblog_id")
    private Long mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.agree_time")
    private Date agreeTime;

    public AgreeMicroblog() {
    }

    public AgreeMicroblog(Long userId, Long mblogId, Date agreeTime) {
        this.userId = userId;
        this.mblogId = mblogId;
        this.agreeTime = agreeTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.644+08:00", comments="Source field: agree_microblog.agree_id")
    public Long getAgreeId() {
        return agreeId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.644+08:00", comments="Source field: agree_microblog.agree_id")
    public void setAgreeId(Long agreeId) {
        this.agreeId = agreeId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.644+08:00", comments="Source field: agree_microblog.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.mblog_id")
    public Long getMblogId() {
        return mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.mblog_id")
    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.agree_time")
    public Date getAgreeTime() {
        return agreeTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.agree_time")
    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }
}