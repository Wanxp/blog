package com.wanxp.blog.repostory;

import com.wanxp.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User数据库操作类
 * 
 * @author John
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);


}
