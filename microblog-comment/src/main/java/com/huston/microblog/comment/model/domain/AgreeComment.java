package com.huston.microblog.comment.model.domain;

import lombok.Data;

import java.util.Date;
import javax.annotation.Generated;

@Data
public class AgreeComment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_id")
    private Long agreeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.comm_id")
    private Long commId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_time")
    private Date agreeTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_id")
    public Long getAgreeId() {
        return agreeId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_id")
    public void setAgreeId(Long agreeId) {
        this.agreeId = agreeId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.comm_id")
    public Long getCommId() {
        return commId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.comm_id")
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_time")
    public Date getAgreeTime() {
        return agreeTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_time")
    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }
}