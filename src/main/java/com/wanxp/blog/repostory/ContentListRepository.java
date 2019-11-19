package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.ContentList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * sys_content_list数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface ContentListRepository extends JpaRepository<ContentList, Integer> {

}
