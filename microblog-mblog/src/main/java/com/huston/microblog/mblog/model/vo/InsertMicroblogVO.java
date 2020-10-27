package com.huston.microblog.mblog.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InsertMicroblogVO {
    @NotBlank
    @Size(max = 5000, message = "微博文本不得超过5000个字符")
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
