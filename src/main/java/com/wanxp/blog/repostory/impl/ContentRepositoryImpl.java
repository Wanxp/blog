package com.wanxp.blog.repostory.impl;

import com.wanxp.blog.model.entity.Content;
import com.wanxp.blog.repostory.ContentRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class ContentRepositoryImpl extends SimpleJpaRepository<Content, Integer> implements ContentRepository {


    public ContentRepositoryImpl(Class<Content> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
