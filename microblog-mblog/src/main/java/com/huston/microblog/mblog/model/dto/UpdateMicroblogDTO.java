package com.huston.microblog.mblog.model.dto;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateMicroblogDTO {

    private Long mblogId;
    private String mblogText;
    private Long userId;

    public Long getMblogId() {
        return mblogId;
    }

    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    public String getMblogText() {
        return mblogText;
    }

    public void setMblogText(String mblogText) {
        this.mblogText = mblogText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
