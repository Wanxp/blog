package com.wanxp.blog.model.dto;

import lombok.Data;

@Data
public class LogDTO extends AbstractDTO {
	private String action;
	private String data;
	private Integer authorId;
	private String ip;
}
