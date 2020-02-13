package com.huston.microblog.auth.aspect.validation;

import com.huston.microblog.auth.aspect.validation.annotation.UserPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UserPasswordValidator implements ConstraintValidator<UserPassword, String> {

    private static Pattern pattern = Pattern.compile("^[^\\u4E00-\\u9FA5\\n]{6,16}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s==null || pattern.matcher(s).matches();
    }
}
