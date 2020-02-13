package com.huston.microblog.auth.model.dto;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserEmailDTO {
    private Long userId;

    private String oldEmailCode;

    private String userEmail;
    private String newEmailCode;

    public UpdateUserEmailDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return "UpdateUserEmailDTO{" +
                "userId=" + userId +
                ", oldEmailCode='" + oldEmailCode + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", newEmailCode='" + newEmailCode + '\'' +
                '}';
    }
}
