package com.wanxp.blog.service;

import com.wanxp.blog.model.dto.ContentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author John
 * 
 */
public interface ContentService {


    /**
     * 获取Content数据表格
     * @param pa
     *            分页帮助类
     * @return
     */
    Page queryInPage(Pageable pa);

	/**
	 * 获取Content数据表格
	 * 
	 * @param content
	 *            参数
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
    Page queryInPage(ContentDTO content, Pageable pa);

    /**
     * 获取Content数据
     *
     * @param authorId 参数
     * @return
     */
    Page listByAuthor(Integer authorId);

	/**
	 * 添加Content
	 * 
	 * @param content
	 */
    void add(ContentDTO content);

    /**
	 * 获得Content对象
	 * 
	 * @param id
	 * @return
	 */
    ContentDTO get(Integer id);

    /**
	 * 修改Content
	 * 
	 * @param content
	 */
    void edit(ContentDTO content);

    /**
	 * 删除Content
	 * 
	 * @param id
	 */
    void delete(Integer id);

    /**
	 * 获取带有评论的内容
	 * @param id
	 * @return
	 */
    ContentDTO getAndCommentPage(Integer id, Pageable pageable);
}
