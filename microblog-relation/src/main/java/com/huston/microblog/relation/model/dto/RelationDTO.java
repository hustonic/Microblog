package com.huston.microblog.relation.model.dto;

import java.util.Date;

/**
 * 关注关系
 * @author huxiantao-cn@foxmail.com
 */
public class RelationDTO {
    private Long relaId;
    private Long userIdSub;
    private Long userIdPub;
    private String relaRemark;
    private Date relaCreTime;

    public Long getRelaId() {
        return relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }

    public Long getUserIdSub() {
        return userIdSub;
    }

    public void setUserIdSub(Long userIdSub) {
        this.userIdSub = userIdSub;
    }

    public Long getUserIdPub() {
        return userIdPub;
    }

    public void setUserIdPub(Long userIdPub) {
        this.userIdPub = userIdPub;
    }

    public String getRelaRemark() {
        return relaRemark;
    }

    public void setRelaRemark(String relaRemark) {
        this.relaRemark = relaRemark;
    }

    public Date getRelaCreTime() {
        return relaCreTime;
    }

    public void setRelaCreTime(Date relaCreTime) {
        this.relaCreTime = relaCreTime;
    }

}
