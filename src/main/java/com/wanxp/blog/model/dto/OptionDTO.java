package com.wanxp.blog.model.dto;

import lombok.Data;

@Data
public class OptionDTO extends AbstractDTO {
	private String name;
	private String value;
	private String description;
}
