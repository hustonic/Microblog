package com.huston.microblog.verification.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum VerificationTypeEnum {
    PERSON          (0, "身份认证"),
    INTEREST        (1, "兴趣认证"),
    ORGANIZATION    (2, "组织认证")
    ;

    private int code;
    private String description;

    VerificationTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public byte getCode() {
        return (byte)code;
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

    public static VerificationTypeEnum valueOf(int code){
        VerificationTypeEnum[] values = values();
        for (VerificationTypeEnum value : values) {
            if(value.code==code)
                return value;
        }
        return null;
    }
}
