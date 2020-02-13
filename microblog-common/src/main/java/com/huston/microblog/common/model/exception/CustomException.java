package com.huston.microblog.common.model.exception;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 6071856616833195724L;

    private int errorCode;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
