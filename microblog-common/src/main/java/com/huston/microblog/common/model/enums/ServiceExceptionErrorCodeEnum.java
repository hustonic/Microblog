package com.huston.microblog.common.model.enums;

/**
 * @author huxiantao-cn@foxmail.com
 */
public enum ServiceExceptionErrorCodeEnum {
    INSERT_USER_ROLE_FAILED(0),
    CREATE_USER_FAILED(1),
    UPDATE_USER_FAILED(2),
    USER_ID_NOT_FOUND(3),
    UPDATE_USER_NAME_FAILED(4),
    VALIDATION_CODE_ERROR(5),
    UPDATE_USER_PHONE_FAILED(6),
    UPDATE_USER_EMAIL_FAILED(7),
    UPDATE_USER_PASSWORD_FAILED(8),

    INSERT_RELATION_FAILED(9),
    DELETE_RELATION_FAILED(10)
    ;

    private int errorCode;

    ServiceExceptionErrorCodeEnum(int errorCode) {
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
