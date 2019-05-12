package com.wanxp.blog.util;

import com.wanxp.blog.model.User;
import com.wanxp.blog.model.dto.UserDTO;
import org.springframework.util.StringUtils;

public class UserUtils {

    /**
     * 判定密码是否相同
     * @param passwordOriginal
     * @param passwordCiphertext
     * @return
     */
    public static Boolean comparePassword(String passwordOriginal, String passwordCiphertext) {
        return !StringUtils.isEmpty(passwordOriginal) && !StringUtils.isEmpty(passwordCiphertext)
                &&  encryptionPassword(passwordOriginal).equals(passwordCiphertext);
    }

    /**
     * 判定密码是否相同
     * @param userOriginal
     * @param userCiphertext
     * @return
     */
    public static Boolean comparePassword(UserDTO userOriginal, User userCiphertext) {
        return userOriginal != null && userCiphertext != null
                && comparePassword(userOriginal.getPassword(), userCiphertext.getPassword());
    }

    public static String encryptionPassword(String password) {
        return MD5Util.md5(password);
    }
}
