package com.wanxp.blog;

import com.wanxp.blog.util.UserUtils;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserTest {
    @Test
    public void testPasswordOut() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456789"));
    }
}
