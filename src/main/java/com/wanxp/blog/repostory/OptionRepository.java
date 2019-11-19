package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Option数据库操作类
 * 
 * @author John
 * 
 */
public interface OptionRepository extends JpaRepository<Option, Integer> {

}
