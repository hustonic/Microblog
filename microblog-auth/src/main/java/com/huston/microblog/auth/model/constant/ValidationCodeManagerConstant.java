package com.huston.microblog.auth.model.constant;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ValidationCodeManagerConstant {

    public final static int VALIDATION_CODE_BIT_COUNT = 6;  //生成验证码的位数

    public final static int VALIDATION_CODE_EXPIRATION = 10 ;  //验证码有效时间，单位分钟

    public final static String VALIDATION_CODE_REDIS_KEY_PREFIX = "validation_code_manager:";  //验证码存储在Redis的Key前缀
}
