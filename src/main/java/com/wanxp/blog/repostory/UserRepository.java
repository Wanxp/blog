package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);


}
