package com.huston.microblog.auth.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum ValidationTypeEnum {
    USER_REGISTRATION_VALIDATE_EMAIL(0, "用户注册微博时验证邮箱"),
    USER_REGISTRATION_VALIDATE_PHONE(1, "用户注册微博时验证手机号"),
    UPDATE_USER_PHONE               (2, "更换手机绑定"),
    UPDATE_USER_EMAIL               (3, "更换邮箱绑定"),
    FIND_PASSWORD_BY_EMAIL          (4, "通过邮箱找回密码"),
    FIND_PASSWORD_BY_PHONE          (5, "通过手机号找回密码")
    ;

    private int type;
    private String description;

    ValidationTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static ValidationTypeEnum valueOf(int type){
        ValidationTypeEnum[] values = ValidationTypeEnum.values();
        for (ValidationTypeEnum value : values) {
            if(value.getType()==type){
                return value;
            }
        }
        return null;
    }
}
