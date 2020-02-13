package com.huston.microblog.auth.model.vo;

import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UserVO {

    private Long userId;

    private String userName;

    private Date userNameSetTime;

    private Byte userNameUpdateTimes;

    private String userEmail;

    private String userPhone;

    private Byte userSex;

    private Date userBirthday;

    private String userIntro;

    private Long resId;

    private String resUrl;

    private Date userCreTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserNameSetTime() {
        return userNameSetTime;
    }

    public void setUserNameSetTime(Date userNameSetTime) {
        this.userNameSetTime = userNameSetTime;
    }

    public Byte getUserNameUpdateTimes() {
        return userNameUpdateTimes;
    }

    public void setUserNameUpdateTimes(Byte userNameUpdateTimes) {
        this.userNameUpdateTimes = userNameUpdateTimes;
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

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Date getUserCreTime() {
        return userCreTime;
    }

    public void setUserCreTime(Date userCreTime) {
        this.userCreTime = userCreTime;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }
}
