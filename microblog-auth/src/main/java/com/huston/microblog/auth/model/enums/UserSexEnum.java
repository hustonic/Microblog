package com.huston.microblog.auth.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum UserSexEnum {
    MALE((byte)0,"男"),
    FEMALE((byte)1, "女")
    ;

    private byte code;
    private String description;

    UserSexEnum(byte code, String description) {
        this.code = code;
        this.description = description;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
