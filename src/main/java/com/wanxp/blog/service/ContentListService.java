package com.wanxp.blog.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.wanxp.blog.model.dto.ContentListDTO;

/**
 * 
 * @author John
 * 
 */
public interface ContentListService {


    /**
     * 获取Content数据表格
     * @param pa
     *            分页帮助类
     * @return
     */
    public List<ContentListDTO> queryInPage(Pageable pa);

}
