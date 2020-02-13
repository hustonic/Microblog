package com.huston.microblog.auth.aspect.validation.annotation;

import com.huston.microblog.auth.aspect.validation.UserNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(UserName.List.class)
@Documented
@Constraint(validatedBy = {UserNameValidator.class})
public @interface UserName {
    String message() default "用户名为4-30个字符，支持中英文、数字、\"_\"、\"-\"";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        UserName[] value();
    }
}
