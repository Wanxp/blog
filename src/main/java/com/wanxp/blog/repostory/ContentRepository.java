package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Content数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

    Page<Content> findByAuthorId(Integer authorId, Pageable pageable);

}
