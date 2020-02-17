package com.huston.microblog.verification.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum VerificationStateEnum {
    VERIFYING   (0, "待审核"),
    FAILED      (1, "认证失败"),
    CONFIRMING  (2, "待确认"),
    FINISHED    (3, "认证成功")
    ;

    private int code;
    private String description;

    VerificationStateEnum(int code, String description) {
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

    public static VerificationStateEnum valueOf(int code){
        VerificationStateEnum[] values = values();
        for (VerificationStateEnum value : values) {
            if(value.code==code)
                return value;
        }
        return null;
    }
}
