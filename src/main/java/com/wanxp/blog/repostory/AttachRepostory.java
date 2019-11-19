package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Attach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Attach数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface AttachRepostory extends JpaRepository<Attach, Integer> {

}
