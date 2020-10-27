package com.huston.microblog.mblog.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateMicroblogVO {
    @NotBlank
    @Size(max = 5000, message = "微博文本不得超过5000个字符")
    private String mblogText;

    public String getMblogText() {
        return mblogText;
    }

    public void setMblogText(String mblogText) {
        this.mblogText = mblogText;
    }
}
