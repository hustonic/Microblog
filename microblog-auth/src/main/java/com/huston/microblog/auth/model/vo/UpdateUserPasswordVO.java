package com.huston.microblog.auth.model.vo;

import com.huston.microblog.auth.aspect.validation.annotation.UserPassword;

import javax.validation.constraints.Null;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserPasswordVO {

    private String oldPassword;
    @UserPassword
    private String userPassword;
    private String userPasswordConfirm;

    public UpdateUserPasswordVO() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPasswordConfirm() {
        return userPasswordConfirm;
    }

    public void setUserPasswordConfirm(String userPasswordConfirm) {
        this.userPasswordConfirm = userPasswordConfirm;
    }

    @Override
    public String toString() {
        return "UpdateUserPasswordVO{" +
                "oldPassword='" + oldPassword + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPasswordConfirm='" + userPasswordConfirm + '\'' +
                '}';
    }
}
