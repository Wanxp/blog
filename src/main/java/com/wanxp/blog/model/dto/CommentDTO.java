package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class CommentDTO {
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
    private Set<CommentDTO> children;
}
