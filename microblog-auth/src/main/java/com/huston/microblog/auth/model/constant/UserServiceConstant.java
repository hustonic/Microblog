package com.huston.microblog.auth.model.constant;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class UserServiceConstant {

    public final static byte USER_UPDATE_NAME_TIMES = 1;    //用户可更新用户名的额外次数

    public final static byte VERIFIED_USER_UPDATE_NAME_TIMES = 1;   //认证用户可更新用户名的额外次数

    public final static byte ADMIN_UPDATE_NAME_TIMES = 1;   //管理员可更新用户名的额外次数

    public final static String USER_ROLE_NAME = "user";     //用户角色的字符串表示

    public final static String VERIFIED_USER_ROLE_NAME = "verified_user";   //认证用户角色的字符串表示

    public final static String ADMIN_ROLE_NAME = "admin";   //管理员角色的字符串表示
}
