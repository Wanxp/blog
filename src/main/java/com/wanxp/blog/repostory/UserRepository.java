package com.wanxp.blog.repostory;

import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User数据库操作类
 *
 * @author John
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);

    @Query("select u from User u where u.username = ?1 or u.email = ?1 or phone = ?1")
    List<User> findUsersByUsernameOrEmailOrPhone(UserDTO userDTO);


}
