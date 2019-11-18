package com.wanxp.blog.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class CommentVO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private Integer cid;
	private Integer created;
	private String author;
	private Integer authorId;
	private Integer ownerId;
	private String mail;
	private String url;
	private String ip;
	private String agent;
	private String content;
	private String type;
	private String status;
	private CommentVO parent;
	private Set<CommentVO> children;
}
