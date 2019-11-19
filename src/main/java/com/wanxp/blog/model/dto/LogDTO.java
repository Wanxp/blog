package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LogDTO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String action;
	private String data;
	private Integer authorId;
	private String ip;
}
