package com.wanxp.blog.model.dto;

import lombok.Data;

@Data
public class ContentListDTO extends AbstractDTO {
	private String title;//标题
	private String categories;//
	private String wordsInfo;//
	private String forward;//内容
	private Integer likeCount;//
	private String userName;//作者
	private String imgUrl;//图片路径
}
