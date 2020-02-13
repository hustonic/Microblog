package com.huston.microblog.auth.model.dto;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserPasswordDTO {
    private Long userId;
    private String oldPassword;
    private String userPassword;

    public UpdateUserPasswordDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

}
