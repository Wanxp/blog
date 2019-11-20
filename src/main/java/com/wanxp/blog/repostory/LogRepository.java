package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Log数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}
