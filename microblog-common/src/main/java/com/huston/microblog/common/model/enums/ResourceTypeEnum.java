package com.huston.microblog.common.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum ResourceTypeEnum {

    PICTURE(0, "图片"),
    VIDEO(1, "视频")
    ;

    private int code;
    private String description;

    ResourceTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
