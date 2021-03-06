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

@SuppressWarnings("serial")
@Entity
@Table(name = "log")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class Log extends AbstractEntity{
;
	@Column(name = "action", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	private String action;
	@Column(name = "data", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	private String data;
	@Column(name = "author_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer authorId;
	@Column(name = "ip", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	private String ip;
}

