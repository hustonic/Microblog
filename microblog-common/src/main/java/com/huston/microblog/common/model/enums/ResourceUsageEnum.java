package com.huston.microblog.common.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum ResourceUsageEnum {
    MICROBLOG           (0, "微博"),
    COMMENT             (1, "评论"),
    HEAD_PICTURE        (2, "头像"),
    MESSAGE             (3, "私信"),
    VERIFICATION        (4, "认证材料")
    ;

    private int code;
    private String description;

    ResourceUsageEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ResourceUsageEnum valueOf(int code){
        ResourceUsageEnum[] resourceUsageEnums = ResourceUsageEnum.values();
        for (ResourceUsageEnum resourceUsageEnum : resourceUsageEnums) {
            if(resourceUsageEnum.getCode()==code){
                return resourceUsageEnum;
            }
        }
        return null;
    }
}
