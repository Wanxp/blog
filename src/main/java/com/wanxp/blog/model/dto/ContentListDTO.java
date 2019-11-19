package com.wanxp.blog.model.dto;

import java.util.Date;

import com.wanxp.blog.constant.Icon;
import lombok.Data;

@Data
public class ContentListDTO {
	private Integer id;
	private Integer tenantId;
	private Date addtime;
	private Date updatetime;
	private Boolean isdeleted;
	private String title;//标题
	private String categories;//
	private String wordsInfo;//
	private String forward;//内容
	private Integer likeCount;//
	private String userName;//作者
	private String imgUrl;//图片路径
}
