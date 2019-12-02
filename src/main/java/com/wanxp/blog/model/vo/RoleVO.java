package com.wanxp.blog.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoleVO {
    private Integer id;
    private Integer tenantId;
    private Date addtime;
    private Date updatetime;
    private Boolean isdeleted;
    private String name;
    private String authority;
    private List<RoleVO> children;
    private RoleVO parent;
}
