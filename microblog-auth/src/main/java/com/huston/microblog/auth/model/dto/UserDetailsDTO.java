package com.huston.microblog.auth.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author 胡献涛
 */
public class UserDetailsDTO implements UserDetails {

    private Long userId;
    private String userPassword;
    private Date userAvailTime;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(Long userId, String userPassword, Date userAvailTime, List<GrantedAuthority> authorities) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userAvailTime = userAvailTime;
        this.authorities = authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserAvailTime() {
        return userAvailTime;
    }

    public void setUserAvailTime(Date userAvailTime) {
        this.userAvailTime = userAvailTime;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userId.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //如果帐号被封号，即 userAvailTime > 当前时间，则返回false
        return userAvailTime.getTime() <= new Date().getTime();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
