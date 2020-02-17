package com.huston.microblog.auth.service.impl;

import com.huston.microblog.auth.mapper.UserMapper;
import com.huston.microblog.auth.model.domain.Role;
import com.huston.microblog.auth.model.domain.User;
import com.huston.microblog.auth.model.dto.UserDetailsDTO;
import com.huston.microblog.auth.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是用于Spring Security身份验证和授权的类
 * @author 胡献涛
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserMapper userMapper;
    private RoleService roleService;

    public UserDetailsServiceImpl(UserMapper userMapper, RoleService roleService) {
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    /**
     * 通过用户输入的登录名加载用户详细信息，登录名可能是手机号、邮箱
     * @param username 登录名
     * @return 用户信息
     * @throws UsernameNotFoundException 找不到用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users;
        //username有可能是手机号、邮箱
        if(StringUtils.isNumeric(username)){
            //手机号
            users = userMapper.selectByUserPhone(username);
        }else{
            //邮箱
            users = userMapper.selectByUserEmail(username);
        }

        if(users.size()==1){
            User user = users.get(0);
            //获取用户的角色
            List<GrantedAuthority> authorities = new ArrayList<>();
            List<Role> roles = roleService.listRole(user.getUserId());
            roles.forEach(role-> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));
            return new UserDetailsDTO(user.getUserId(), user.getUserPassword(), user.getUserAvailTime(), authorities);
        }else if(users.size()==0){
            throw new UsernameNotFoundException("用户不存在");
        }else{
            throw new UsernameNotFoundException("参数对应的用户有多个，无法识别用户");
        }
    }

}
