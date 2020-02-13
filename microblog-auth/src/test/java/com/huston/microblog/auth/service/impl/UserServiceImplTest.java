package com.huston.microblog.auth.service.impl;

import com.huston.microblog.auth.model.dto.InsertUserDTO;
import com.huston.microblog.auth.model.enums.UserSexEnum;
import com.huston.microblog.auth.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * @author huxiantao-cn@foxmail.com
 */
@SpringBootTest
class UserServiceImplTest {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserServiceImplTest(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    void insertUser() {

    }
}