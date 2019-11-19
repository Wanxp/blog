package com.wanxp.blog.model.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;

@Data
public class ContentDTO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;
	private Date updatetime;
	private Boolean isdeleted;
	private String title;
	private String slug;
	private String thumbImg;
	private String content;
	private Integer authorId;
	private String type;
	private String status;
	private String fmtType;
	private String tags;
	private String categories;
	private Integer hits;
	private Integer commentsNum;
	private Integer allowComment;
	private Integer allowPing;
	private Integer allowFeed;
	private Page<CommentDTO> commentPage;
}
