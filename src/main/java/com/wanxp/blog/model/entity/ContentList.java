/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model.entity;

import java.util.Date;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "sys_content_list")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class ContentList extends AbstractEntity{
	@Column(name = "title", unique = false, nullable = true, length = 10)
	private String title;//标题
	@Column(name = "categories", unique = false, nullable = true, length = 10)
	private String categories;//
	@Column(name = "words_info", unique = false, nullable = true, length = 10)
	private String wordsInfo;//
	@Column(name = "forward", unique = false, nullable = true, length = 10)
	private String forward;//内容
	@Column(name = "like_count", unique = false, nullable = true, length = 10)
	private Integer likeCount;//
	@Column(name = "user_name", unique = false, nullable = true, length = 10)
	private String userName;//作者
	@Column(name = "img_url", unique = false, nullable = true, length = 10)
	private String imgUrl;//图片路径

}

