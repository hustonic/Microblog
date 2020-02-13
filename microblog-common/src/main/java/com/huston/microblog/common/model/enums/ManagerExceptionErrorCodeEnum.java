package com.huston.microblog.common.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum ManagerExceptionErrorCodeEnum {
    SEND_VALIDATION_CODE_TO_PHONE_FAILED(0),  //发送手机验证码失败
    SEND_VALIDATION_CODE_TO_EMAIL_FAILED(1)     //发送邮箱验证码失败
    ;

    private int errorCode;

    ManagerExceptionErrorCodeEnum(int errorCode) {
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
