package com.wanxp.blog.model.vo;

import com.wanxp.blog.validation.groups.Login;
import com.wanxp.blog.validation.groups.Registry;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserVO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	@Size(min = 8, max = 32,groups = {Login.class, Registry.class}, message = "{user.username_size.error}")
	private String username;
	@Size(min = 8, max = 32, groups = {Login.class, Registry.class}, message = "{user.password_size.error}")
	private String password;
	@Email(groups = {Registry.class}, message = "{user.email_error}")
	private String email;
	private String homeUrl;
	private String screenName;
	private Integer created;
	private Integer activated;
	private Integer logged;
	private String groupName;
	private Boolean remeberMe;
}
