package com.huston.microblog.auth.model.dto;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserPhoneDTO {
    private Long userId;

    private String oldPhoneCode;

    private String userPhone;
    private String newPhoneCode;

    public UpdateUserPhoneDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPhoneCode() {
        return oldPhoneCode;
    }

    public void setOldPhoneCode(String oldPhoneCode) {
        this.oldPhoneCode = oldPhoneCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getNewPhoneCode() {
        return newPhoneCode;
    }

    public void setNewPhoneCode(String newPhoneCode) {
        this.newPhoneCode = newPhoneCode;
    }

    @Override
    public String toString() {
        return "UpdateUserPhoneDTO{" +
                "userId=" + userId +
                ", oldPhoneCode='" + oldPhoneCode + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", newPhoneCode='" + newPhoneCode + '\'' +
                '}';
    }
}
