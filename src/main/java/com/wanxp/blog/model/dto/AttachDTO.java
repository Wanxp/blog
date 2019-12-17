package com.wanxp.blog.model.dto;

import lombok.Data;

@Data
public class AttachDTO extends AbstractDTO {
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
