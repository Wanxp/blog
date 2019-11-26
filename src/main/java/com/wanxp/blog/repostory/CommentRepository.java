package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.Comment;
import com.wanxp.blog.model.entity.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comment数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Page<Comment> findByCid(Integer id, Pageable pageable);

}
