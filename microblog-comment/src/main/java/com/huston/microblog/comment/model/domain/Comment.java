package com.huston.microblog.comment.model.domain;

import lombok.Data;

import java.util.Date;
import javax.annotation.Generated;

@Data
public class Comment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_id")
    private Long commId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.res_id")
    private Long resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.mblog_id")
    private Long mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_id_parent")
    private Long commIdParent;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_cre_time")
    private Date commCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_text")
    private String commText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_id")
    public Long getCommId() {
        return commId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_id")
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.res_id")
    public Long getResId() {
        return resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.res_id")
    public void setResId(Long resId) {
        this.resId = resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.mblog_id")
    public Long getMblogId() {
        return mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.mblog_id")
    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_id_parent")
    public Long getCommIdParent() {
        return commIdParent;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_id_parent")
    public void setCommIdParent(Long commIdParent) {
        this.commIdParent = commIdParent;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_cre_time")
    public Date getCommCreTime() {
        return commCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.comm_cre_time")
    public void setCommCreTime(Date commCreTime) {
        this.commCreTime = commCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.334+08:00", comments="Source field: comment.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.comm_text")
    public String getCommText() {
        return commText;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.comm_text")
    public void setCommText(String commText) {
        this.commText = commText;
    }
}