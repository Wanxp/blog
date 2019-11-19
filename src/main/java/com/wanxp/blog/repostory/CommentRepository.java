package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comment数据库操作类
 * 
 * @author John
 * 
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public Page<Comment> findByCid(Integer id, Pageable pageable);
}
