package com.wanxp.blog.service.impl;

import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.model.entity.User;
import com.wanxp.blog.repostory.UserRepository;
import com.wanxp.blog.service.AccountService;
import com.wanxp.blog.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.wanxp.blog.constant.CacheKey.USE_USER_NAME;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 加载用户信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Cacheable(value = USE_USER_NAME, key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user : " + username + " not found ");
        }
        return BeanUtils.copyProperties(user, UserDTO.class);
    }

    /**
     * 注册
     *
     * @param userDTO
     * @return
     */
    public UserDetails register(UserDTO userDTO) {
        checkUserExist(userDTO);
        return null;
    }

    protected void checkUserExist(UserDTO userDTO) {
        List<User> users = userRepository.findUsersByUsernameOrEmailOrPhone(userDTO);
        if (!CollectionUtils.isEmpty(users)) {
            throw new ApplicationContextException("use is exist");
        }
    }
}
