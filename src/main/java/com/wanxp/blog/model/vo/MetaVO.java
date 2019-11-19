package com.wanxp.blog.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MetaVO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String name;
	private String slug;
	private String type;
	private String description;
	private Integer sort;
	private Integer parent;
}
