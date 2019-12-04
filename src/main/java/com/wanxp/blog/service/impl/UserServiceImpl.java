package com.wanxp.blog.service.impl;

import com.wanxp.blog.repostory.UserRepository;
import com.wanxp.blog.model.entity.User;
import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.service.UserService;
import com.wanxp.blog.util.BeanUtils;
import com.wanxp.blog.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.wanxp.blog.constant.CacheKey.USE_USER_NAME;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Value("${LOGIN_NAME}")
    private String cacheNameSpaceForLogin;

	@Autowired
	private UserRepository userRepository;

    @Override
    public Page<UserDTO> queryInPage(UserDTO commentDTO, Pageable pa) {
        Page<User> p = userRepository.findAll(pa);
        List<UserDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            UserDTO d = new UserDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<UserDTO>(ds);
    }

    @Override
    public void add(UserDTO dto) {
        User t = new User();
        BeanUtils.copyProperties(dto, t);
        userRepository.saveAndFlush(t);
    }

    @Override
    public UserDTO get(Integer id) {
        User t = userRepository.getOne(id);
        UserDTO dto = new UserDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    @CacheEvict(value="emp",key="#dto.username")
    public void edit(UserDTO dto) {
        User t = new User();
        BeanUtils.copyProperties(dto, t);
        userRepository.save(t);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public UserDTO login(UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (!UserUtils.comparePassword(userDTO, user)) {
            return null;
        }
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setPassword(null);
        return userDTO;
    }

    @Override
    @Cacheable(value = USE_USER_NAME, key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user : " + username + " not found " );
        }
        return BeanUtils.copyProperties(user, UserDTO.class);
    }
}
