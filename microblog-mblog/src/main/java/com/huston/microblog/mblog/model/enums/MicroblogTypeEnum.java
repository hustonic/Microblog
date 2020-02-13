package com.huston.microblog.mblog.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum MicroblogTypeEnum {

    TEXT    (0, "纯文本"),
    PICTURE (1, "图片"),
    VIDEO   (2, "视频"),
    FORWARD (3, "转发")
    ;

    private int code;
    private String description;

    MicroblogTypeEnum(int code, String description) {
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

    public static MicroblogTypeEnum valueOf(int code){
        MicroblogTypeEnum[] values = values();
        for (MicroblogTypeEnum value : values) {
            if(value.code==code)
                return value;
        }
        return null;
    }
}
