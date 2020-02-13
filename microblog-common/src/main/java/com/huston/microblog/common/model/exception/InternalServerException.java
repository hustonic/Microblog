package com.huston.microblog.common.model.exception;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InternalServerException extends CustomException {

    private static final long serialVersionUID = -4383003629917691705L;

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(int errorCode, String message) {
        super(errorCode, message);
    }

    public InternalServerException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

}
