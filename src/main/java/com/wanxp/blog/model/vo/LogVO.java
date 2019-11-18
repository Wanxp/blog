package com.wanxp.blog.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class LogVO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String action;
	private String data;
	private Integer authorId;
	private String ip;
	private Integer created;
}
