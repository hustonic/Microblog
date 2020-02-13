package com.huston.microblog.auth.aspect.validation;

import com.huston.microblog.auth.aspect.validation.annotation.ValidationCode;
import com.huston.microblog.auth.model.constant.ValidationCodeManagerConstant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ValidationCodeValidator implements ConstraintValidator<ValidationCode, String> {

    private static Pattern pattern = Pattern.compile("^\\d{"+ ValidationCodeManagerConstant.VALIDATION_CODE_BIT_COUNT +"}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s==null || pattern.matcher(s).matches();
    }
}
