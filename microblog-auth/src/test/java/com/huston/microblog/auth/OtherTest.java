package com.huston.microblog.auth;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author huxiantao-cn@foxmail.com
 */
class OtherTest {
    @Test
    void testString(){
        System.out.println(new BCryptPasswordEncoder().encode("abc123"));
    }
}
