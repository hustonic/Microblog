package com.huston.microblog.auth.aspect.validation.annotation;

import com.huston.microblog.auth.aspect.validation.ValidationCodeValidator;
import com.huston.microblog.auth.model.constant.ValidationCodeManagerConstant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ValidationCode.List.class)
@Documented
@Constraint(validatedBy = {ValidationCodeValidator.class})
public @interface ValidationCode {
    String message() default "验证码为"+ ValidationCodeManagerConstant.VALIDATION_CODE_BIT_COUNT+"位数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        ValidationCode[] value();
    }
}
