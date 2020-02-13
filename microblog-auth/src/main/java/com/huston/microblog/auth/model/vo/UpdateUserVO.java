package com.huston.microblog.auth.model.vo;

import com.huston.microblog.auth.aspect.validation.annotation.*;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UpdateUserVO{

    @UserName
    private String userName;

    private String oldPassword;

    @UserPassword
    private String userPassword;

    private Byte userSex;

    @PastOrPresent(message = "生日必须小于或等于当前时间")
    private Date userBirthday;

    @Size(max = 70, message = "用户简介必须小于或等于70个字符")
    private String userIntro;

    private Long resId;


    public UpdateUserVO(Byte userSex, Date userBirthday, String userIntro, Long resId) {
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userIntro = userIntro;
        this.resId = resId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
