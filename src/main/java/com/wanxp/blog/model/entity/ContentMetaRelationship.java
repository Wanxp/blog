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
@Table(name = "content_meta_relationship")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class ContentMetaRelationship extends AbstractEntity{
	@Column(name = "content_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Integer contentId;
	@Column(name = "meta_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Integer metaId;
}

