package com.huston.microblog.common.model.vo;


import java.io.Serializable;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 9123353272776520609L;

    private boolean success;
    private T data;
    private String message;

    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static <T> Result<T> success(){
        return new Result<>(true);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(true, data);
    }

    public static <T> Result<T> fail(String message){
        return new Result<>(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
