package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.ContentMetaRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ContentMetaRelationship数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface ContentMetaRelationshipRepository extends JpaRepository<ContentMetaRelationship, Integer> {

}
