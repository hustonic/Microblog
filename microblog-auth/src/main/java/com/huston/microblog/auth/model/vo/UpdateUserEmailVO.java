package com.huston.microblog.auth.model.vo;

import com.huston.microblog.auth.aspect.validation.annotation.Email;
import com.huston.microblog.auth.aspect.validation.annotation.ValidationCode;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserEmailVO {
    @ValidationCode
    private String oldEmailCode;
    @Email
    private String userEmail;
    @ValidationCode
    private String newEmailCode;

    public UpdateUserEmailVO() {
    }

    public String getOldEmailCode() {
        return oldEmailCode;
    }

    public void setOldEmailCode(String oldEmailCode) {
        this.oldEmailCode = oldEmailCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNewEmailCode() {
        return newEmailCode;
    }

    public void setNewEmailCode(String newEmailCode) {
        this.newEmailCode = newEmailCode;
    }

    @Override
    public String toString() {
        return "UpdateUserEmailVO{" +
                "oldEmailCode='" + oldEmailCode + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", newEmailCode='" + newEmailCode + '\'' +
                '}';
    }
}
