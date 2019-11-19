package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AttachDTO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;
	private Date updatetime;
	private Boolean isdeleted;
	private Integer cid;
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
	private CommentDTO parent;
}
