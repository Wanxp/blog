package com.wanxp.blog.model.vo;

import lombok.Data;

import java.util.Date;
@Data
public class AttachVO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String fname;
	private String ftype;
	private String fkey;
	private Integer authorId;
}
