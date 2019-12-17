package com.wanxp.blog.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 10)
    private Integer id;
    @Column(name = "tenant_id", unique = false, nullable = true, insertable = true, updatable = false, length = 10)
    private Integer tenantId;
    @Column(name = "addtime", unique = false, nullable = false, insertable = true, updatable = false, length = 19)
    private Date addtime;
    @Column(name = "updatetime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
    private Date updatetime;
    @Column(name = "isdeleted", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
    private Boolean isdeleted;
    @Column(name = "createBy", unique = false, nullable = false, insertable = true, updatable = false, length = 10)
    private Integer createBy;
    @Column(name = "modifiedBy", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    private Integer modifiedBy;
}
