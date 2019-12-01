package com.wanxp.blog.model.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.util.Date;

@Data
public class RoleDTO implements GrantedAuthority {
    private Integer id;
    private Integer tenantId;
    private Date addtime;
    private Date updatetime;
    private Boolean isdeleted;
    private String name;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
