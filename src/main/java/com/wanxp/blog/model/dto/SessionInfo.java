package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.List;

/**
 * session信息模型
 * 
 * @author John
 * 
 */
@Data
public class SessionInfo {
	private String id;// 用户ID
	private String name;// 用户登录名
	private String ip;// 用户IP
	private String roleIds; // 用户角色Id集合
	private List<String> resourceList;// 用户可以访问的资源地址列表
}
