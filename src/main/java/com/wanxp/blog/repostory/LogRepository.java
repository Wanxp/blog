package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Log数据库操作类
 * 
 * @author John
 * 
 */
public interface LogRepository extends JpaRepository<Log, Integer> {

}
