package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Content;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Content数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

    @Query("select c from Content c where p.attributes[?1] = ?2")
    List<Content> findByAttributeAndValue(String attribute, Object value);

    @Query("select c from Content c where p.attributes[?1] = ?2")
    List<Content> findByAttributeAndValuePageable(String attribute, Object value, Pageable page);
}
