package com.huston.microblog.auth.aspect.validation;

import com.huston.microblog.auth.aspect.validation.annotation.UserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UserNameValidator implements ConstraintValidator<UserName, String> {

    private static Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5\\w-]{4,30}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s==null || pattern.matcher(s).matches();
    }
}
