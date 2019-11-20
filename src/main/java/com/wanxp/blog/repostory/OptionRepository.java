package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Option数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {

}
