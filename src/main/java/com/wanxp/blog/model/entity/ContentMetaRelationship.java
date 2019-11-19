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
public class ContentMetaRelationship {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 10)
	private Integer id;
	@Column(name = "tenant_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	private Integer tenantId;
	@Column(name = "addtime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	private Date addtime;
	@Column(name = "updatetime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	private Date updatetime;
	@Column(name = "isdeleted", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	private Boolean isdeleted;
	@Column(name = "content_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Integer contentId;
	@Column(name = "meta_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Integer metaId;
}

