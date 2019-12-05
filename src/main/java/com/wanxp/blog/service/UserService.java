package com.wanxp.blog.service;

import com.wanxp.blog.model.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * 
 * @author John
 * 
 */
public interface UserService {

	/**
     * 获取User数据表格
     *
     * @param user 参数
     * @param pa   分页帮助类
     * @return
     */
    Page queryInPage(UserDTO user, Pageable pa);

	/**
	 * 添加User
     *
     * @param user
     */
    void add(UserDTO user);

    /**
     * 获得User对象
     *
     * @param id
     * @return
     */
    UserDTO get(Integer id);

    /**
     * 修改User
     *
     * @param user
     */
    void edit(UserDTO user);

    /**
     * 删除User
     *
     * @param id
     */
    void delete(Integer id);
}
