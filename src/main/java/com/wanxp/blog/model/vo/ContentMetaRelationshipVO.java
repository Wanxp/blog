package com.wanxp.blog.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContentMetaRelationshipVO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private Integer contentId;
	private Integer metaId;
}
