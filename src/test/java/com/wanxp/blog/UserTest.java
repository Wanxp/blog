package com.wanxp.blog;

import com.wanxp.blog.util.UserUtils;
import org.junit.Test;

public class UserTest {
    @Test
    public void testPasswordOut() {
        System.out.println(UserUtils.encryptionPassword("123456789"));
    }
}
