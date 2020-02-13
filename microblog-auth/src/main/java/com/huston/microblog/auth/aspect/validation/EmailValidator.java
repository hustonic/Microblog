package com.huston.microblog.auth.aspect.validation;

import com.huston.microblog.auth.aspect.validation.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

    private static Pattern pattern=Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       return s==null || pattern.matcher(s).matches();
    }
}
