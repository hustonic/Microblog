package com.huston.microblog.mblog.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum TimelineTypeEnum {

    MICROBLOG_FOLLOW(0, "关注的人的微博列表"),
    MICROBLOG_ME(1, "自己发布的微博列表")
    ;

    private int code;
    private String description;

    TimelineTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }

    public static TimelineTypeEnum valueOf(int code){
        TimelineTypeEnum[] values = values();
        for (TimelineTypeEnum value : values) {
            if(value.code==code)
                return value;
        }
        return null;
    }
}
