package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ContentMetaRelationshipDTO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private Integer contentId;
	private Integer metaId;
}
