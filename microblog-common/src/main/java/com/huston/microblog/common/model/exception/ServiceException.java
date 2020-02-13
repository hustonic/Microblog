package com.huston.microblog.common.model.exception;


/**
 * @author huxiantao-cn@foxmail.com
 */
public class ServiceException extends CustomException {

    private static final long serialVersionUID = -6925628873908914097L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(int errorCode, String message) {
        super(errorCode, message);
    }

    public ServiceException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
