package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Meta数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer> {

}
