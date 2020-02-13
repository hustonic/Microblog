package com.huston.microblog.common.model.exception;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ControllerException extends CustomException {
    private static final long serialVersionUID = 1569998927755433109L;

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(int errorCode, String message) {
        super(errorCode, message);
    }

    public ControllerException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
