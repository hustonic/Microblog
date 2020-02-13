package com.huston.microblog.common.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class MicroblogDTO {

    private Long mblogId;

    private String mblogText;

    private Byte mblogType;

    private Long mblogIdForward;

    private Date mblogPubTime;

    private Long userId;

    private List<String> resUrls = new ArrayList<>();

    private MicroblogDTO microblogForward;



    public MicroblogDTO getMicroblogForward() {
        return microblogForward;
    }

    public void setMicroblogForward(MicroblogDTO microblogForward) {
        this.microblogForward = microblogForward;
    }

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

    public Byte getMblogType() {
        return mblogType;
    }

    public void setMblogType(Byte mblogType) {
        this.mblogType = mblogType;
    }

    public Long getMblogIdForward() {
        return mblogIdForward;
    }

    public void setMblogIdForward(Long mblogIdForward) {
        this.mblogIdForward = mblogIdForward;
    }

    public Date getMblogPubTime() {
        return mblogPubTime;
    }

    public void setMblogPubTime(Date mblogPubTime) {
        this.mblogPubTime = mblogPubTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getResUrls() {
        return resUrls;
    }

    public void setResUrls(List<String> resUrls) {
        this.resUrls = resUrls;
    }
}
