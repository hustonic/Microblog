package com.huston.microblog.common.model.exception;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ManagerException extends CustomException {

    private static final long serialVersionUID = -4654852815321451618L;

    public ManagerException(String message) {
        super(message);
    }

    public ManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerException(int errorCode, String message) {
        super(errorCode, message);
    }

    public ManagerException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
