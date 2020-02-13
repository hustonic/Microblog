package com.huston.microblog.auth.mapper;

import com.huston.microblog.auth.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author 胡献涛
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insertUser() {
    }

    @Test
    void selectUserPhoneByUserId (){
        Optional<User> optionalUser = userMapper.selectUserPhoneByUserId(10000L);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            System.out.println(user.getUserPhone());
        }
    }
}