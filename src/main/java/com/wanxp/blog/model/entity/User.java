/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 10)
	private Integer id;
	@Column(name = "tenant_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer tenantId;
	@Column(name = "addtime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	private Date addtime;
	@Column(name = "updatetime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	private Date updatetime;
	@Column(name = "isdeleted", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	private Boolean isdeleted;
	@Column(name = "username", unique = true, nullable = false, insertable = true, updatable = true, length = 64)
	private String username;
	@Column(name = "password", unique = false, nullable = false, insertable = true, updatable = true, length = 64)
	private String password;
	@Column(name = "email", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	private String email;
	@Column(name = "home_url", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	private String homeUrl;
	@Column(name = "screen_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	private String screenName;
	@Column(name = "activated", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer activated;
	@Column(name = "logged", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer logged;
	@Column(name = "group_name", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	private String groupName;
}

