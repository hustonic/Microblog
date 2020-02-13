package com.huston.microblog.mblog.model.vo;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InsertMicroblogVO {
    @NotBlank
    private String mblogText;
    private Byte mblogType;
    private Long mblogIdForward;

    private List<Long> resIds;

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

    public List<Long> getResIds() {
        return resIds;
    }

    public void setResIds(List<Long> resIds) {
        this.resIds = resIds;
    }
}
