package com.huston.microblog.auth.model.dto;

import com.huston.microblog.auth.aspect.validation.annotation.UserPassword;
import com.huston.microblog.auth.aspect.validation.annotation.ValidationCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class FindPasswordDTO {

    private String emailOrPhone;

    @ValidationCode
    private String validationCode;

    @Min(value = 4, message = "validationType可取4或5")
    @Max(value= 5, message = "validationType可取4或5")
    private Integer validationType;

    @UserPassword
    private String newPassword;


    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public Integer getValidationType() {
        return validationType;
    }

    public void setValidationType(Integer validationType) {
        this.validationType = validationType;
    }
}
