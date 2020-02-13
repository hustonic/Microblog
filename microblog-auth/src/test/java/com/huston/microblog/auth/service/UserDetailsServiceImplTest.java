package com.huston.microblog.auth.service;

import com.huston.microblog.auth.mapper.UserMapper;
import com.huston.microblog.auth.model.domain.User;
import com.huston.microblog.auth.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huxiantao-cn@foxmail.com
 */
@SpringBootTest
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserMapper userMapper;

    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setUserName("test2");
        System.out.println(user.getUserId());
    }
}