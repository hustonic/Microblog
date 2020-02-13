package com.huston.microblog.auth.model.vo;

import com.huston.microblog.auth.aspect.validation.annotation.Phone;
import com.huston.microblog.auth.aspect.validation.annotation.ValidationCode;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserPhoneVO {

    @ValidationCode
    private String oldPhoneCode;
    @Phone
    private String userPhone;
    @ValidationCode
    private String newPhoneCode;

    public UpdateUserPhoneVO() {
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
        return "UpdateUserPhoneVO{" +
                "oldPhoneCode='" + oldPhoneCode + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", newPhoneCode='" + newPhoneCode + '\'' +
                '}';
    }
}
