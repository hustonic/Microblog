package com.huston.microblog.mblog.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Microblog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.6+08:00", comments="Source field: microblog.mblog_id")
    private Long mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_type")
    private Byte mblogType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_id_forward")
    private Long mblogIdForward;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_pub_time")
    private Date mblogPubTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.mblog_text")
    private String mblogText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.605+08:00", comments="Source field: microblog.mblog_id")
    public Long getMblogId() {
        return mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_id")
    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_type")
    public Byte getMblogType() {
        return mblogType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_type")
    public void setMblogType(Byte mblogType) {
        this.mblogType = mblogType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_id_forward")
    public Long getMblogIdForward() {
        return mblogIdForward;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.606+08:00", comments="Source field: microblog.mblog_id_forward")
    public void setMblogIdForward(Long mblogIdForward) {
        this.mblogIdForward = mblogIdForward;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.mblog_pub_time")
    public Date getMblogPubTime() {
        return mblogPubTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.mblog_pub_time")
    public void setMblogPubTime(Date mblogPubTime) {
        this.mblogPubTime = mblogPubTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.mblog_text")
    public String getMblogText() {
        return mblogText;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.607+08:00", comments="Source field: microblog.mblog_text")
    public void setMblogText(String mblogText) {
        this.mblogText = mblogText;
    }
}