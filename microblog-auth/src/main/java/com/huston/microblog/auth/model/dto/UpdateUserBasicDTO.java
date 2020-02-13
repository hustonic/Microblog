package com.huston.microblog.auth.model.dto;

import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserBasicDTO {

    private Long userId;
    private Byte userSex;
    private Date userBirthday;
    private String userIntro;
    private Long resId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }


    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "userSex=" + userSex +
                ", userBirthday=" + userBirthday +
                ", userIntro='" + userIntro + '\'' +
                ", resId=" + resId +
                '}';
    }
}
