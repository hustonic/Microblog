package com.huston.microblog.auth.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class User {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.945+08:00", comments="Source field: user.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name")
    private String userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name_set_time")
    private Date userNameSetTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name_update_times")
    private Byte userNameUpdateTimes;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_email")
    private String userEmail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_phone")
    private String userPhone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_password")
    private String userPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.955+08:00", comments="Source field: user.user_sex")
    private Byte userSex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_birthday")
    private Date userBirthday;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_intro")
    private String userIntro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.res_id")
    private Long resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.957+08:00", comments="Source field: user.user_cre_time")
    private Date userCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.957+08:00", comments="Source field: user.user_avail_time")
    private Date userAvailTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.952+08:00", comments="Source field: user.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name")
    public String getUserName() {
        return userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name_set_time")
    public Date getUserNameSetTime() {
        return userNameSetTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name_set_time")
    public void setUserNameSetTime(Date userNameSetTime) {
        this.userNameSetTime = userNameSetTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name_update_times")
    public Byte getUserNameUpdateTimes() {
        return userNameUpdateTimes;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.953+08:00", comments="Source field: user.user_name_update_times")
    public void setUserNameUpdateTimes(Byte userNameUpdateTimes) {
        this.userNameUpdateTimes = userNameUpdateTimes;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_email")
    public String getUserEmail() {
        return userEmail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_email")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_phone")
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_password")
    public String getUserPassword() {
        return userPassword;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.954+08:00", comments="Source field: user.user_password")
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_sex")
    public Byte getUserSex() {
        return userSex;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_sex")
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_birthday")
    public Date getUserBirthday() {
        return userBirthday;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_birthday")
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_intro")
    public String getUserIntro() {
        return userIntro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.user_intro")
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.res_id")
    public Long getResId() {
        return resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.956+08:00", comments="Source field: user.res_id")
    public void setResId(Long resId) {
        this.resId = resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.957+08:00", comments="Source field: user.user_cre_time")
    public Date getUserCreTime() {
        return userCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.957+08:00", comments="Source field: user.user_cre_time")
    public void setUserCreTime(Date userCreTime) {
        this.userCreTime = userCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.957+08:00", comments="Source field: user.user_avail_time")
    public Date getUserAvailTime() {
        return userAvailTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.957+08:00", comments="Source field: user.user_avail_time")
    public void setUserAvailTime(Date userAvailTime) {
        this.userAvailTime = userAvailTime;
    }
}