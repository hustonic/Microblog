package com.huston.microblog.auth.aspect.validation;

import com.huston.microblog.auth.aspect.validation.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    private static Pattern pattern = Pattern.compile("^1[3-9]\\d{9}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s==null || pattern.matcher(s).matches();
    }
}
