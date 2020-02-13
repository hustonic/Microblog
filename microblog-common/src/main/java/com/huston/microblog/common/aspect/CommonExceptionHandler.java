package com.huston.microblog.common.aspect;

import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

/**
 * 统一异常处理类
 * @author huxiantao-cn@foxmail.com
 */
public class CommonExceptionHandler {

    //处理参数验证异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindException(MethodArgumentNotValidException e){
        StringBuilder errorMessage=new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(error-> errorMessage.append(error.getDefaultMessage()).append(";"));
        return Result.fail(errorMessage.toString());
    }

    //处理参数验证异常
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleConstraintViolationException(ConstraintViolationException e){
        StringBuilder errorMessage=new StringBuilder();
        e.getConstraintViolations().forEach(error-> errorMessage.append(error.getMessage()).append(";"));
        return Result.fail(errorMessage.toString());
    }

    //参数验证异常
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindException(BindException e){
        StringBuilder errorMessage=new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(error-> errorMessage.append(error.getDefaultMessage()).append(";"));
        return Result.fail(errorMessage.toString());
    }

    //处理请求参数缺失的异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return Result.fail("缺少某些请求参数");
    }

    //参数类型错误
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return Result.fail("参数类型不匹配");
    }

    //客户端错误
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBadRequestException(BadRequestException e){
        return Result.fail(e.getMessage());
    }

    //服务器内部异常
    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleInternalServerException(InternalServerException e){
        e.printStackTrace();
        return Result.fail("服务器发生未知错误");
    }

    //处理自定义异常
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Result handleCustomException(CustomException e){
        return Result.fail(e.getMessage());
    }

    //处理未知异常
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleThrowable(Throwable e){
        e.printStackTrace();
        return Result.fail("服务器发生未知错误");
    }

}
