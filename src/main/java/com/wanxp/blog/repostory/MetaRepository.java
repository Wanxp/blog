package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Meta数据库操作类
 * 
 * @author John
 * 
 */
public interface MetaRepository extends JpaRepository<Meta, Integer> {

}
