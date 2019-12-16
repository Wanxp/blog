package com.wanxp.blog.model.dto;

import lombok.Data;

@Data
public class ContentMetaRelationshipDTO extends AbstractDTO {
	private Integer contentId;
	private Integer metaId;
}
