package com.huston.microblog.common.model.exception;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class BadRequestException extends CustomException{

    private static final long serialVersionUID = 4284190785473216973L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(int errorCode, String message) {
        super(errorCode, message);
    }

    public BadRequestException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

}
