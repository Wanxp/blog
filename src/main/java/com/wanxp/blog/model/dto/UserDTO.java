package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO  {
	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String username;
	private String password;
	private String email;
	private String homeUrl;
	private String screenName;
	private Integer activated;
	private Integer logged;
	private String groupName;
}
