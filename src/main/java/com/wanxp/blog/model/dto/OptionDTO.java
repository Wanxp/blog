package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OptionDTO  {
	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String name;
	private String value;
	private String description;
}
