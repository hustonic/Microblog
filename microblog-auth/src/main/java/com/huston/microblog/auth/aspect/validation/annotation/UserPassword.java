package com.huston.microblog.auth.aspect.validation.annotation;

import com.huston.microblog.auth.aspect.validation.UserNameValidator;
import com.huston.microblog.auth.aspect.validation.UserPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(UserPassword.List.class)
@Documented
@Constraint(validatedBy = {UserPasswordValidator.class})
public @interface UserPassword {
    String message() default "密码为6～16位字母、数字或符号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        UserPassword[] value();
    }
}