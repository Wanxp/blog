/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "comment")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Comment extends AbstractEntity {
	@Column(name = "cid", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Integer cid;
	@Column(name = "author", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	private String author;
	@Column(name = "author_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer authorId;
	@Column(name = "owner_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer ownerId;
	@Column(name = "mail", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	private String mail;
	@Column(name = "url", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private String url;
	@Column(name = "ip", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String ip;
	@Column(name = "agent", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private String agent;
	@Column(name = "content", unique = false, nullable = false, insertable = true, updatable = true, length = 16777215)
	private String content;
	@Column(name = "type", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	private String type;
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	private String status;
	@ManyToOne
	@JoinColumn(name = "parent", unique = false, nullable = true, insertable = true, updatable = true)
	private Comment parent;

	@OneToMany
	@JoinColumn(name = "parent", unique = false, nullable = true, insertable = true, updatable = true)
    private Set<Comment> children;

}

