package com.wanxp.blog.model.vo;

import com.wanxp.blog.constant.Icon;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;

@Data
public class ContentVO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String title;
	private String slug;
	private String thumbImg;
	private Integer created;
	private Integer modified;
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
	private String iconClassName;
	private String url;
	private Page<CommentVO> commentPage;
}
