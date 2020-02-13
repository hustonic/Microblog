package com.huston.microblog.auth.model.dto;

import com.huston.microblog.auth.aspect.validation.annotation.UserName;
import com.huston.microblog.auth.aspect.validation.annotation.UserPassword;
import lombok.Data;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class UpdateUserDTO {

    private Long userId;

    private String userName;

    private String oldPassword;

    private String userPassword;

    private Byte userSex;

    private Date userBirthday;

    private String userIntro;

    private Long resId;
}
