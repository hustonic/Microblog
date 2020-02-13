package com.huston.microblog.mblog.model.dto;

import com.huston.microblog.mblog.model.constant.BaseConst;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InsertMicroblogDTO {

    private String mblogText;
    private Byte mblogType;
    private Long mblogIdForward;
    private Long userId;

    private List<Long> resIds;


    public Long getMblogIdForward() {
        return mblogIdForward;
    }

    public void setMblogIdForward(Long mblogIdForward) {
        this.mblogIdForward = mblogIdForward;
    }

    public Byte getMblogType() {
        return mblogType;
    }

    public void setMblogType(Byte mblogType) {
        this.mblogType = mblogType;
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

    public List<Long> getResIds() {
        return resIds;
    }

    public void setResIds(List<Long> resIds) {
        this.resIds = resIds;
    }
}
