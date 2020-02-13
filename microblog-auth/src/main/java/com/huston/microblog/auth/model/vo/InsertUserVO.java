package com.huston.microblog.auth.model.vo;

import com.huston.microblog.auth.aspect.validation.annotation.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InsertUserVO {

    @UserName
    private String userName;
    @Email
    private String userEmail;
    @Phone
    private String userPhone;
    @UserPassword
    private String userPassword;

    @ValidationCode
    private String validationCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }
}
