package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AbstractDTO {
    private Integer id;
    private Integer tenantId;
    private Date addtime;
    private Date updatetime;
    private Boolean isdeleted;
    private Integer createBy;
    private Integer modifiedBy;
}
