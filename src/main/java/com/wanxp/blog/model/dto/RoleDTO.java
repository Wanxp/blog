package com.wanxp.blog.model.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.List;

@Data
public class RoleDTO extends AbstractDTO implements GrantedAuthority {
    private Integer id;
    private Integer tenantId;
    private Date addtime;
    private Date updatetime;
    private Boolean isdeleted;
    private String name;
    private String authority;
    private List<RoleDTO> children;
    private RoleDTO parent;

    @Override
    public String getAuthority() {
        return authority;
    }
}
