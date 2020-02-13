package com.huston.microblog.common.model.dto;

import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ResourceDTO {
    private Long resId;

    private String resUrl;

    private Byte resType;

    private Byte resUsage;

    private Date resCreTime;

    private Long userId;

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Byte getResType() {
        return resType;
    }

    public void setResType(Byte resType) {
        this.resType = resType;
    }

    public Byte getResUsage() {
        return resUsage;
    }

    public void setResUsage(Byte resUsage) {
        this.resUsage = resUsage;
    }

    public Date getResCreTime() {
        return resCreTime;
    }

    public void setResCreTime(Date resCreTime) {
        this.resCreTime = resCreTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
