package com.wanxp.blog.model.dto;

import lombok.Data;

@Data
public class MetaDTO extends AbstractDTO {
	private String name;
	private String slug;
	private String type;
	private String description;
	private Integer sort;
	private Integer parent;
}
