/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
@Entity
@Table(name = "content")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class Content extends AbstractEntity{
	@Column(name = "title", unique = false, nullable = false, insertable = true, updatable = true, length = 255)
	private String title;
	@Column(name = "slug", unique = true, nullable = true, insertable = true, updatable = true, length = 255)
	private String slug;
	@Column(name = "thumb_img", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	private String thumbImg;
	@Column(name = "content", unique = false, nullable = true, insertable = true, updatable = true, length = 16777215)
	private String content;
	@Column(name = "author_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Integer authorId;
	@Column(name = "type", unique = false, nullable = false, insertable = true, updatable = true, length = 16)
	private String type;
	@Column(name = "status", unique = false, nullable = false, insertable = true, updatable = true, length = 16)
	private String status;
	@Column(name = "fmt_type", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	private String fmtType;
	@Column(name = "tags", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private String tags;
	@Column(name = "categories", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private String categories;
	@Column(name = "hits", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer hits;
	@Column(name = "comments_num", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer commentsNum;
	@Column(name = "allow_comment", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer allowComment;
	@Column(name = "allow_ping", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer allowPing;
	@Column(name = "allow_feed", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer allowFeed;

}

