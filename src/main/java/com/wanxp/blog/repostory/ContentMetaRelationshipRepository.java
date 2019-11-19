package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.ContentMetaRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ContentMetaRelationship数据库操作类
 * 
 * @author John
 * 
 */
public interface ContentMetaRelationshipRepository extends JpaRepository<ContentMetaRelationship, Integer> {

}
