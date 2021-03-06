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
@Table(name = "meta")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class Meta extends AbstractEntity {
	@Column(name = "name", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	private String name;
	@Column(name = "slug", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private String slug;
	@Column(name = "type", unique = false, nullable = false, insertable = true, updatable = true, length = 32)
	private String type;
	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	private String description;
	@Column(name = "sort", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer sort;
	@Column(name = "parent", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer parent;
}

