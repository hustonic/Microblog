package com.huston.microblog.resource.model.exception;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = -6292353241037621668L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
